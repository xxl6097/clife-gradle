package com.clife.gradle.bean.lib;

import java.io.Serializable;
import java.util.List;

public class LibrariesBean implements Serializable {
    private List<LibraryBean> libs;

    public List<LibraryBean> getLibs() {
        return libs;
    }

    public void setLibs(List<LibraryBean> libs) {
        this.libs = libs;
    }

    @Override
    public String toString() {
        return "LibrariesBean{" +
                "libs=" + libs +
                '}';
    }
}
