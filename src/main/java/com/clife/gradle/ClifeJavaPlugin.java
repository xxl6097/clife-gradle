package com.clife.gradle;

import com.clife.gradle.api.ConfigApi;
import com.clife.gradle.api.LibraryApi;
import com.clife.gradle.api.PropertyApi;
import com.clife.gradle.bean.lib.LibraryBean;
import com.clife.gradle.bean.lib.VersionBean;
import com.clife.gradle.util.Logc;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.util.ArrayList;
import java.util.List;

public class ClifeJavaPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        Logc.project = project;
        Logc.e("=====================ClifeJavaPlugin===>>>>");
        PropertyApi.getApi().init(project);
        ConfigApi.getApi().init(project);
        LibraryApi.getApi().init(project);
    }

    public static void main(String[] args){
        VersionBean v1 = new VersionBean();
        v1.setVersion("0.0.0-SNAPSHOT");
        v1.setVersion("0.0.1-SNAPSHOT");
        v1.setVersion("2.0.1-SNAPSHOT");
        v1.setVersion("3.0.0-SNAPSHOT");
        List<VersionBean> snapshot = new ArrayList<>();
        snapshot.add(new VersionBean("0.0.0-SNAPSHOT"));
        snapshot.add(new VersionBean("0.0.1-SNAPSHOT"));
        snapshot.add(new VersionBean("2.0.1-SNAPSHOT"));
        snapshot.add(new VersionBean("3.0.0-SNAPSHOT"));
        snapshot.add(new VersionBean("0.2.1-SNAPSHOT"));
        LibraryBean lib = new LibraryBean();
        lib.setGroup("com.github.szhittech");
        lib.setName("hetxxxsdk");
        lib.setSnapshot(snapshot);
        String vbe = lib.getGroupName(false);
        System.out.println(vbe.toCharArray());

    }
}
