package com.mobily.elite.ui.home.model;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Momen on 3/26/2022
 */
public class ModelData {

    private String id;
    private String name;
    private String jobName;
    private Drawable image;
    private Drawable fullcv;

    public ModelData(String id, String name, String jobName, Drawable image, Drawable fullcv) {
        this.id = id;
        this.name = name;
        this.jobName = jobName;
        this.image = image;
        this.fullcv = fullcv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Drawable getFullcv() {
        return fullcv;
    }

    public void setFullcv(Drawable fullcv) {
        this.fullcv = fullcv;
    }
}
