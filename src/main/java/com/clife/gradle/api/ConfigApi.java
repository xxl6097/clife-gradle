package com.clife.gradle.api;

import com.clife.gradle.bean.conf.ConfigBean;
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

public class ConfigApi {
    private static ConfigApi api;
    private ConfigBean config;

    public static ConfigApi getApi() {
        if (api == null) {
            synchronized (ConfigApi.class) {
                if (api == null) {
                    api = new ConfigApi();
                }
            }
        }
        return api;
    }

    public ConfigBean getConfig() {
        return config;
    }

    public void init(Project project) {
        String filepath = PropertyApi.getApi().getProperty().getConfJsonUri();
        if (filepath.startsWith("http")) {
            config = Util.getServerJson(filepath, ConfigBean.class);
            Logc.e(WordUtil.STRING_4 + filepath);
            if (config == null) {
                Logc.e("get conf json null");
                throw new NullPointerException("get conf json null");
            }
        } else {
            File file = new File(project.getRootDir(), filepath);
            if (!file.exists()) {
                throw new IllegalStateException(WordUtil.STRING_5 + file.getAbsolutePath() + WordUtil.STRING_6 + file.getAbsolutePath());
            }
            try {
                Reader reader = new BufferedReader(new FileReader(file));
                config = new Gson().fromJson(reader, ConfigBean.class);
                Logc.e(WordUtil.STRING_7 + file.getCanonicalPath());
                if (config == null) {
                    throw new NullPointerException(WordUtil.STRING_8);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalStateException(WordUtil.STRING_6 + file.getAbsolutePath() + WordUtil.STRING_9 + e.getMessage());
            }

        }
    }
}
