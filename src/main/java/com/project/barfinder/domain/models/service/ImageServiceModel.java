package com.project.barfinder.domain.models.service;

import com.project.barfinder.domain.entities.Bar;

public class ImageServiceModel extends BaseServiceModel {
    private String url;
    private BarServiceModel bar;

    public ImageServiceModel() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BarServiceModel getBar() {
        return bar;
    }

    public void setBar(BarServiceModel bar) {
        this.bar = bar;
    }
}
