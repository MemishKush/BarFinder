package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Bar;

public class EventCreateBindingModel {
    private String bar;
    private String startTime;
    private String endTime;
    private String description;

    public EventCreateBindingModel() {
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
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
