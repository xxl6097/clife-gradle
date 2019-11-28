package com.clife.gradle.api;

import com.clife.gradle.bean.lib.LibrariesBean;
import com.clife.gradle.bean.lib.LibraryBean;
import com.clife.gradle.util.Logc;
import com.clife.gradle.util.Util;
import com.clife.gradle.util.WordUtil;
import com.google.gson.Gson;

import org.gradle.api.Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryApi {
    private static LibraryApi api;
    private LibrariesBean libraries;
    private Map<String, LibraryBean> libraryMap = new HashMap<>();

    public static LibraryApi getApi() {
        if (api == null) {
            synchronized (LibraryApi.class) {
                if (api == null) {
                    api = new LibraryApi();
                }
            }
        }
        return api;
    }

    public LibrariesBean getLibraries() {
        return libraries;
    }

    public Map<String, LibraryBean> getLibraryMap() {
        return libraryMap;
    }

    public LibraryBean getLibrary(String name) {
        LibraryBean lib = libraryMap.get(name);
        if (lib != null) {
//            Logc.e("===>getLibrary:" + lib.toString());
        }
        return lib;
    }

    public void init(Project project) {
        String filepath = PropertyApi.getApi().getProperty().getLibraryJsonUri();
        if (filepath.startsWith("http")) {
            libraries = Util.getServerJson(filepath, LibrariesBean.class);
            Logc.e(WordUtil.STRING_4 + filepath);
            if (libraries == null) {
                Logc.e("get server json null");
                //throw new NullPointerException("get server json null");
            }
        } else {
            File file = new File(project.getRootDir(), filepath);
            if (!file.exists()) {
                throw new IllegalStateException(WordUtil.STRING_5 + file.getAbsolutePath() + WordUtil.STRING_6 + file.getAbsolutePath());
            }
            try {
                Reader reader = new BufferedReader(new FileReader(file));
                libraries = new Gson().fromJson(reader, LibrariesBean.class);
                Logc.e(WordUtil.STRING_7 + file.getCanonicalPath());
                if (libraries == null) {
                    throw new NullPointerException(WordUtil.STRING_8);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalStateException(WordUtil.STRING_6 + file.getAbsolutePath() + WordUtil.STRING_9 + e.getMessage());
            }

        }

        if (libraries != null) {
            List<LibraryBean> libs = libraries.getLibs();
            if (libs != null && libs.size() > 0) {
                for (LibraryBean item : libs) {
                    libraryMap.put(item.getName(), item);
                }
            }

        }

//        Logc.e("===>libraries:" + libraries.toString());
//        Logc.e("===>libraryMap:" + libraryMap.toString());
    }
}
