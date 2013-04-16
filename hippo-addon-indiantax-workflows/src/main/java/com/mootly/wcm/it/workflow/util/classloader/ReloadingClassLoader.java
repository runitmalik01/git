package com.mootly.wcm.it.workflow.util.classloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureClassLoader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ReloadingClassLoader extends SecureClassLoader implements Cloneable {
    private Map cache = new HashMap();
    private String name;

    protected ReloadingClassLoader() {
        this(ClassLoader.getSystemClassLoader());
    }

    protected ReloadingClassLoader(ClassLoader parent) {
        super(parent);
    }

    protected synchronized Class loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        if (this.name == null) {
            this.name = name;
        }

        Class c = (Class) cache.get(name);
        if (c != null) return c;

        if (this.name.equals(name)) {
            try {
                c = findClass(name);
            } catch (ClassNotFoundException ex) {
                return super.loadClass(name, resolve);
            }
        } else {
            return super.loadClass(name, resolve);
        }
        cache.put(name, c);
        return c;
    }

    protected Class findClass(String name) throws ClassNotFoundException {
        String path = name.replace('.', '/').concat(".class");
        byte[] data = getFile(path);
        if (data == null)
            throw new ClassNotFoundException();

        return defineClass(name, data, 0, data.length);
    }

    protected URL findResource(String name) {
        byte[] data = this.getFile(name);

        if (data == null)
            return null;
        try {
            return getDataURL(name, data);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    protected abstract URL getDataURL(String name, byte[] data) throws MalformedURLException;

    protected Enumeration findResources(String name) {
        URL url = this.findResource(name);

        if (url == null)
            return null;

        return Collections.enumeration(Collections.singleton(url));
    }

    public abstract boolean isStale();

    protected abstract byte[] getFile(String path);

    public static ReloadingClassLoader getInstance(List dirs) {
        return getInstance(dirs, ClassLoader.getSystemClassLoader());
    }

    public static ReloadingClassLoader getInstance(List dirs, ClassLoader parent) {
        return new DirectoryClassLoader(dirs, parent);
    }

    public abstract Object clone();
}