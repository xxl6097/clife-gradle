package com.clife.gradle.bean.conf;

import org.gradle.api.Project;

import java.io.Serializable;
import java.util.List;

public class ConfigBean implements Serializable {

    /**
     * name : hetbasicsdk
     * group : com.github.szhittech
     * pomPackaging : aar
     * jcenter : {"username":"szhittech","password":"het123456","snapshots":"http://200.200.200.40:8083/nexus/content/repositories/clife-android-snapshots/","releaseurl":"https://oss.sonatype.org/service/local/staging/deploy/maven2/"}
     * clife : {"username":"clife-android","password":"add123","snapshots":"http://200.200.200.40:8083/nexus/content/repositories/clife-android-snapshots/","releaseurl":"http://200.200.200.40:8083/nexus/content/repositories/clife-android-releases/","publicurl":"http://200.200.200.40:8083/nexus/content/groups/public"}
     * repo : ["asfjesjfesf","skfejfe"]
     * docLink : http://svn.uuxia.cn/svn/repositories/android/wiki/android/open/index.html
     * isrelease : 0
     * librariesuri : ["http://svn.uuxia.cn/svn/repositories/android/code/trunk/public/sdkversion.json","http://svn.uuxia.cn/svn/repositories/android/code/trunk/public/conf.json"]
     */

    private String name;
    private String group;
    private String pomPackaging;
    private JcenterBean jcenter;
    private ClifeBean clife;
    private String docLink;
    private int isrelease;
    private List<String> repo;
    private List<String> librariesuri;
    /**
     * extension : {"configuration":"archives","sign":false}
     */

    private ExtensionBean extension;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPomPackaging() {
        return pomPackaging;
    }

    public void setPomPackaging(String pomPackaging) {
        this.pomPackaging = pomPackaging;
    }

    public JcenterBean getJcenter() {
        return jcenter;
    }

    public void setJcenter(JcenterBean jcenter) {
        this.jcenter = jcenter;
    }

    public ClifeBean getClife() {
        return clife;
    }

    public void setClife(ClifeBean clife) {
        this.clife = clife;
    }

    public String getDocLink() {
        return docLink;
    }

    public void setDocLink(String docLink) {
        this.docLink = docLink;
    }

    public int getIsrelease() {
        return isrelease;
    }

    public void setIsrelease(int isrelease) {
        this.isrelease = isrelease;
    }

    public List<String> getRepo() {
        return repo;
    }

    public void setRepo(List<String> repo) {
        this.repo = repo;
    }

    public List<String> getLibrariesuri() {
        return librariesuri;
    }

    public void setLibrariesuri(List<String> librariesuri) {
        this.librariesuri = librariesuri;
    }

    public ExtensionBean getExtension() {
        return extension;
    }

    public void setExtension(ExtensionBean extension) {
        this.extension = extension;
    }

    public static class JcenterBean {
        /**
         * username : szhittech
         * password : het123456
         * snapshots : http://200.200.200.40:8083/nexus/content/repositories/clife-android-snapshots/
         * releaseurl : https://oss.sonatype.org/service/local/staging/deploy/maven2/
         */

        private String username;
        private String password;
        private String snapshots;
        private String releaseurl;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSnapshots() {
            return snapshots;
        }

        public void setSnapshots(String snapshots) {
            this.snapshots = snapshots;
        }

        public String getReleaseurl() {
            return releaseurl;
        }

        public void setReleaseurl(String releaseurl) {
            this.releaseurl = releaseurl;
        }
    }

    public static class ClifeBean {
        /**
         * username : clife-android
         * password : add123
         * snapshots : http://200.200.200.40:8083/nexus/content/repositories/clife-android-snapshots/
         * releaseurl : http://200.200.200.40:8083/nexus/content/repositories/clife-android-releases/
         * publicurl : http://200.200.200.40:8083/nexus/content/groups/public
         */

        private String username;
        private String password;
        private String snapshots;
        private String releaseurl;
        private String publicurl;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSnapshots() {
            return snapshots;
        }

        public void setSnapshots(String snapshots) {
            this.snapshots = snapshots;
        }

        public String getReleaseurl() {
            return releaseurl;
        }

        public void setReleaseurl(String releaseurl) {
            this.releaseurl = releaseurl;
        }

        public String getPublicurl() {
            return publicurl;
        }

        public void setPublicurl(String publicurl) {
            this.publicurl = publicurl;
        }
    }

    public static class ExtensionBean {
        /**
         * configuration : archives
         * sign : false
         */

        private String configuration;
        private boolean sign;

        public String getConfiguration() {
            return configuration;
        }

        public void setConfiguration(String configuration) {
            this.configuration = configuration;
        }

        public boolean isSign() {
            return sign;
        }

        public void setSign(boolean sign) {
            this.sign = sign;
        }
    }
}
