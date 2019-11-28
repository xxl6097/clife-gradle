package com.clife.gradle.bean.lib;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LibraryBean implements Serializable {
    private String name;
    private String group;
    private String docLink;
    private List<VersionBean> release;
    private List<VersionBean> snapshot;

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

    public String getDocLink() {
        return docLink;
    }

    public void setDocLink(String docLink) {
        this.docLink = docLink;
    }


    public List<VersionBean> getRelease() {
        return release;
    }

    public void setRelease(List<VersionBean> release) {
        this.release = release;
    }

    public List<VersionBean> getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(List<VersionBean> snapshot) {
        this.snapshot = snapshot;
    }

    public String getGroupName(boolean isRelease,int index) {
        VersionBean version = snapshot.get(index);
        if (isRelease) {
            version = release.get(index);
        }
        return String.format("%s:%s:%s", group, name, version.getVersion());
    }

    public String getGroupName(boolean isRelease) {
        List<VersionBean> versions = snapshot;
        if (isRelease) {
            versions = release;
        }
        VersionBean version = Collections.max(versions);
        return String.format("%s:%s:%s", group, name, version.getVersion());
    }

    public String getVersion(boolean isRelease){
        List<VersionBean> versions = snapshot;
        if (isRelease) {
            versions = release;
        }
        VersionBean version = Collections.max(versions);
        return version.getVersion();
    }


    public String getUrl(boolean isRelease){
        if (group==null)
            return "";
        String[] arr = group.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (String str : arr){
            sb.append(str);
            sb.append("/");
        }
        sb.append(name);
        sb.append("/");
        sb.append(getVersion(isRelease));
        sb.append("/");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "LibraryBean{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", docLink='" + docLink + '\'' +
                ", release=" + release +
                ", snapshot=" + snapshot +
                '}';
    }
}
