package com.clife.gradle.api;

import com.clife.gradle.bean.prop.PropertyBean;

import org.gradle.api.Project;
import org.gradle.api.plugins.ExtraPropertiesExtension;

public class PropertyApi {
    private static PropertyApi api;
    private PropertyBean property = new PropertyBean();

    public static PropertyApi getApi() {
        if (api == null) {
            synchronized (PropertyApi.class) {
                if (api == null) {
                    api = new PropertyApi();
                }
            }
        }
        return api;
    }

    public PropertyBean getProperty() {
        return property;
    }

    public void init(Project project) {
        ExtraPropertiesExtension extraProperties = project.getExtensions().getExtraProperties();
        if (extraProperties.has(KEY.CLIFE_LIBS_URI)) {
            Object obj2 = extraProperties.get(KEY.CLIFE_LIBS_URI);
            if (obj2 != null && obj2 instanceof String) {
                String str = (String) obj2;
                property.setLibraryJsonUri(str);
            }
        }

        if (extraProperties.has(KEY.CLIFE_CONF_URI)) {
            Object obj2 = extraProperties.get(KEY.CLIFE_CONF_URI);
            if (obj2 != null && obj2 instanceof String) {
                String str = (String) obj2;
                property.setConfJsonUri(str);
            }
        }

        if (extraProperties.has(KEY.CLIFE_SVN_USERNAME)) {
            Object uname = extraProperties.get(KEY.CLIFE_SVN_USERNAME);
            if (uname != null && uname instanceof String) {
                String str = (String) uname;
                property.setSvnUserName(str);
            }
        }

        if (extraProperties.has(KEY.CLIFE_SVN_PASSWORD)) {
            Object obj2 = extraProperties.get(KEY.CLIFE_SVN_PASSWORD);
            if (obj2 != null && obj2 instanceof String) {
                String str = (String) obj2;
                property.setSvnPassWord(str);
            }
        }

        if (extraProperties.has(KEY.CLIFE_MAVEN_TYPE)) {
            Object obj2 = extraProperties.get(KEY.CLIFE_MAVEN_TYPE);
            if (obj2 != null) {
                String value = obj2.toString();
                try {
                    int mType = Integer.parseInt(value);
                    property.setMavenTye(mType);
                } catch (Exception e) {
                    if (e == null)
                        return;
                    e.printStackTrace();
                }

            }
        }
    }


    public final class KEY {
        public final static String CLIFE_LIBS_URI = "clife.libs.uri";
        public final static String CLIFE_CONF_URI = "clife.conf.uri";
        public final static String CLIFE_SVN_USERNAME = "clife.svn.username";
        public final static String CLIFE_SVN_PASSWORD = "clife.svn.password";
        public final static String CLIFE_MAVEN_TYPE = "clife.maven.type";
    }
}
