package com.mootly.wcm.it.workflow.util.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mootly.wcm.it.workflow.util.ClassUtils;

public class DirectoryClassLoader extends ReloadingClassLoader {
    private List dirs;
    private Map timestamps = new HashMap();

    public DirectoryClassLoader(List dirs, ClassLoader parent) {
        super(parent);
        this.dirs = dirs;
    }

    public boolean isStale() {
        Iterator iter = timestamps.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            File toCheck = findFile((String) entry.getKey());
            if (toCheck != null) {
                long time = ((Long) entry.getValue()).longValue();
                if (toCheck.lastModified() > time) {
                    return true;
                }
            }
        }
        return false;
    }

    private File findFile(String fileName) {
        for (Iterator iterator = dirs.iterator(); iterator.hasNext();) {
            File dir = (File) iterator.next();
            File file = new File(dir, fileName);
            if (file.exists()) {
                return file;
            }
        }

        return null;
    }

    protected URL getDataURL(String name, byte[] data) throws MalformedURLException {
        File file = findFile(name);
        if (file == null) {
            return null;
        }

        return new URL(null, file.getParentFile().toURL().toExternalForm() + '/' + name, new BytesURLStreamHandler(data));
    }

    public byte[] getFile(String path) {
        try {
            InputStream in = null;
            int size = 0;

            File f = findFile(path);
            if (f == null) {
                return null;
            }

            if (!f.exists()) return null;
            size = (int) f.length();
            in = new FileInputStream(f);
            //we're ok not storing timestamps for jars, since the whole jar
            //will be modified in that case.
            timestamps.put(path, new Long(f.lastModified()));

            byte[] data = ClassUtils.readStream(in, size);
            return data;
        } catch (IOException e) {
            return null;
        }
    }

    public Object clone() {
        DirectoryClassLoader loader = new DirectoryClassLoader(dirs, getParent());
        return loader;
    }
}