package com.clife.gradle.util;

import com.clife.gradle.api.PropertyApi;
import com.clife.gradle.http.SimpleHttpUtils;
import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public static <T> T getServerJson(String url, Class<T> cls) {
        if (url == null || url.equalsIgnoreCase(""))
            throw new IllegalArgumentException(WordUtil.STRING_10);
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("username", PropertyApi.getApi().getProperty().getSvnUserName());
            headers.put("password", PropertyApi.getApi().getProperty().getSvnPassWord());
            String msg = SimpleHttpUtils.get(url, headers);
            //Logc.e("========>>>>>>>>" + msg);
            return new Gson().fromJson(msg, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param version1
     * @param version2
     * @return >0 version1>version2,<0 version1 < version2
     */
    public static int versionCompareTo(String version1, String version2) {
        version1 = version1 == null ? "" : version1.replaceAll("[^\\d\\.]+", "");
        version2 = version2 == null ? "" : version2.replaceAll("[^\\d\\.]+", "");
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        List<Integer> version1List = new ArrayList<Integer>();
        List<Integer> version2List = new ArrayList<Integer>();
        for (int i = 0; i < version1Array.length; i++) {
            version1List.add(Integer.parseInt(version1Array[i]));
        }
        for (int i = 0; i < version2Array.length; i++) {
            version2List.add(Integer.parseInt(version2Array[i]));
        }
        int size = version1List.size() > version2List.size() ? version1List.size() : version2List.size();
        while (version1List.size() < size) {
            version1List.add(0);
        }
        while (version2List.size() < size) {
            version2List.add(0);
        }
        for (int i = 0; i < size; i++) {
            if (version1List.get(i) > version2List.get(i)) {
                return 1;
            }
            if (version1List.get(i) < version2List.get(i)) {
                return -1;
            }
        }
        return 0;
    }

    public static int ping(int timeout, String checkUrl) {
        // 个人觉得使用MIUI这个链接有失效的风险
//        final String checkUrl = "https://www.baidu.com";

        HttpURLConnection connection = null;
        try {
            URL url = new URL(checkUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(false);
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setUseCaches(false);
            connection.connect();

            return connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return -1;
    }

}
