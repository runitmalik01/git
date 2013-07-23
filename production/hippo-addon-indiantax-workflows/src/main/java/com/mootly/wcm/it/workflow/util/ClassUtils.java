/**
 * $RCSfile$
 * $Revision: 16717 $
 * $Date: 2005-06-28 15:51:04 -0700 (Tue, 28 Jun 2005) $
 *
 * Copyright (C) 1999-2004 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software.
 * Use is subject to license terms.
 */

package com.mootly.wcm.it.workflow.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.it.workflow.util.classloader.ReloadingClassLoader;

/**
 * A utility class to assist with loading classes or resources by name. Many
 * application servers use custom classloaders, which will break uses of:
 * <pre>
 *    Class.forName(className);
 * </pre>
 *
 * This utility attempts to load the class or resource using a number of different
 * mechanisms to work around this problem.
 *
 * @author Matt Tucker
 */
public class ClassUtils {
    private static final String RELOADING_CLASSLOADER_DIR = "reloading.classloader.dir";
    private static final String RELOADING_CLASSLOADER_REGEX = "reloading.classloader.regex";

    private static ClassUtils instance = new ClassUtils();

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    //static {
    //    ObjectFactory.setObjectFactory(new JiveObjectFactory());
    //}

    List dirs;
    boolean propertiesLoaded;

    /**
     * Loads the class with the specified name.
     *
     * @param className the name of the class
     * @return the resulting <code>Class</code> object
     * @exception ClassNotFoundException if the class was not found
     */
    public static Class forName(String className) throws ClassNotFoundException {
        return instance.loadClass(className);
    }

    /**
     * Loads the given resource as a stream.
     *
     * @param name the name of the resource that exists in the classpath.
     * @return the resource as an input stream or <tt>null</tt> if the resource was not found.
     */
    public static InputStream getResourceAsStream(String name) {
        return instance.loadResource(name);
    }

    public static void propertiesLoaded() {
        instance.propertiesLoaded = true;
    }

    /**
     * Not instantiatable.
     */
    private ClassUtils() {}

    private Class loadClass(String className) throws ClassNotFoundException {
        List dirs = getDirs();
        if (dirs.isEmpty()) {
            return loadNormalClass(className);
        }
        else {
            String regex = SymbolGlobals.getSymbolProperty(RELOADING_CLASSLOADER_REGEX);
            if (regex != null && className.matches(regex)) {
                log.warn("(Re)loading class " + className);
                return loadReloadingClass(className, dirs);
            } else {
                return loadNormalClass(className);
            }
        }
    }

    private List getDirs() {
        if (!propertiesLoaded) {
            return Collections.EMPTY_LIST;
        }

        if (dirs == null) {
            List dirNames = SymbolGlobals.getSymbolProperties(RELOADING_CLASSLOADER_DIR);
            if (dirNames.isEmpty()) {
                dirs = Collections.EMPTY_LIST;
            } else {
                dirs = new ArrayList(dirNames.size());
                for (Iterator iterator = dirNames.iterator(); iterator.hasNext();) {
                    String dirName = (String) iterator.next();
                    File dir = new File(dirName);
                    dirs.add(dir);
                }
            }
        }

        return dirs;
    }

    private Class loadNormalClass(String className) throws ClassNotFoundException {
        Class theClass = null;
        try {
            theClass = Class.forName(className);
        }
        catch (ClassNotFoundException e1) {
            try {
                theClass = Thread.currentThread().getContextClassLoader().loadClass(className);
            }
            catch (ClassNotFoundException e2) {
                theClass = getClass().getClassLoader().loadClass(className);
            }
        }
        return theClass;
    }

    private Class loadReloadingClass(String name, List dirs) throws ClassNotFoundException {
        ClassLoader parentCl = Thread.currentThread().getContextClassLoader();
        ReloadingClassLoader rcl = ReloadingClassLoader.getInstance(dirs, parentCl);
        rcl = (ReloadingClassLoader) rcl.clone();
        return rcl.loadClass(name);
    }


    private InputStream loadResource(String name) {
        InputStream in = getClass().getResourceAsStream(name);
        if (in == null) {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
            if (in == null) {
                in = getClass().getClassLoader().getResourceAsStream(name);
            }
        }
        return in;
    }

    /**
     * Load a class with a given name.
     * <p/>
     * It will try to load the class in the following order:
     * <ul>
     * <li>From {@link Thread#getContextClassLoader() Thread.currentThread().getContextClassLoader()}
     * <li>Using the basic {@link Class#forName(String) }
     * <li>From {@link Class#getClassLoader() ClassLoaderUtil.class.getClassLoader()}
     * <li>From the {@link Class#getClassLoader() callingClass.getClassLoader() }
     * </ul>
     *
     * @param className    The name of the class to load
     * @param callingClass The Class object of the calling object
     * @throws ClassNotFoundException If the class cannot be found anywhere.
     */
    public static Class loadClass(String className, Class callingClass)
            throws ClassNotFoundException {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException ex) {
                try {
                    return ClassUtils.class.getClassLoader().loadClass(className);
                } catch (ClassNotFoundException exc) {
                    return callingClass.getClassLoader().loadClass(className);
                }

            }
        }
    }

    /**
     * Load a given resource.
     * <p/>
     * This method will try to load the resource using the following methods (in order):
     * <ul>
     * <li>From {@link Thread#getContextClassLoader() Thread.currentThread().getContextClassLoader()}
     * <li>From {@link Class#getClassLoader() ClassLoaderUtil.class.getClassLoader()}
     * <li>From the {@link Class#getClassLoader() callingClass.getClassLoader() }
     * </ul>
     *
     * @param resourceName The name of the resource to load
     * @param callingClass The Class object of the calling object
     */
    public static URL getResource(String resourceName, Class callingClass) {
        URL url = null;

        url = Thread.currentThread().getContextClassLoader().getResource(resourceName);

        if (url == null) {
            url = ClassUtils.class.getClassLoader().getResource(resourceName);
        }

        if (url == null) {
            url = callingClass.getClassLoader().getResource(resourceName);
        }
        return url;
    }

    /**
     * This is a convenience method to load a resource as a stream.
     * <p/>
     * The algorithm used to find the resource is given in getResource()
     *
     * @param resourceName The name of the resource to load
     * @param callingClass The Class object of the calling object
     */
    public static InputStream getResourceAsStream(String resourceName, Class callingClass) {
        URL url = getResource(resourceName, callingClass);
        try {
            return url != null ? url.openStream() : null;
        } catch (IOException e) {
            return null;
        }
    }

    public static byte[] readStream(InputStream in, int size) throws IOException {
        if (in == null) return null;
        if (size == 0) return new byte[0];
        int currentTotal = 0;
        int bytesRead;
        byte[] data = new byte[size];
        while (currentTotal < data.length && (bytesRead = in.read(data, currentTotal, data.length - currentTotal)) >= 0)
            currentTotal += bytesRead;
        in.close();
        return data;
    }

    //static class JiveObjectFactory extends ObjectFactory {
    //    public Class getClassInstance(String className) throws ClassNotFoundException {
    //        return instance.loadClass(className);
      //  }
    //}
}
