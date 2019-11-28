package com.clife.gradle.bean.prop;

import java.io.Serializable;

public class PropertyBean implements Serializable {
    //http://200.200.200.40/svn/repositories/android/code/trunk/public/sdkversion.json
    private String libraryJsonUri="http://200.200.200.40/svn/repositories/android/code/trunk/public/sdkversion.json";;
    private String confJsonUri= "http://200.200.200.40/svn/repositories/android/code/trunk/public/conf.json";
    private String svnUserName= "eysin";
    private String svnPassWord="eysin";
    //0:内外maven的SNAPSHOT版
    //1:内外maven的release版
    //2:sonatype的SNAPSHOT版
    //3:JCenter的release版
    private int mavenTye = 0;

    public PropertyBean() {
    }

    public String getLibraryJsonUri() {
        return libraryJsonUri;
    }

    public void setLibraryJsonUri(String libraryJsonUri) {
        this.libraryJsonUri = libraryJsonUri;
    }

    public String getConfJsonUri() {
        return confJsonUri;
    }

    public void setConfJsonUri(String confJsonUri) {
        this.confJsonUri = confJsonUri;
    }

    public String getSvnUserName() {
        return svnUserName;
    }

    public void setSvnUserName(String svnUserName) {
        this.svnUserName = svnUserName;
    }

    public String getSvnPassWord() {
        return svnPassWord;
    }

    public void setSvnPassWord(String svnPassWord) {
        this.svnPassWord = svnPassWord;
    }

    public int getMavenTye() {
        return mavenTye;
    }

    public void setMavenTye(int mavenTye) {
        this.mavenTye = mavenTye;
    }

    @Override
    public String toString() {
        return "PropertyBean{" +
                "libraryJsonUri='" + libraryJsonUri + '\'' +
                ", confJsonUri='" + confJsonUri + '\'' +
                ", svnUserName='" + svnUserName + '\'' +
                ", svnPassWord='" + svnPassWord + '\'' +
                '}';
    }
}
