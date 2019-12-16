package com.project.barfinder.domain.models.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.EventCategory;

public class EventServiceModel extends BaseServiceModel {
    private BarServiceModel bar;
    private String title;
    private String startTime;
    private String endTime;
    private String description;
    private EventCategory eventCategory;

    public EventServiceModel()  {
    }

    public BarServiceModel getBar() {
        return bar;
    }

    public void setBar(BarServiceModel bar) {
        this.bar = bar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
