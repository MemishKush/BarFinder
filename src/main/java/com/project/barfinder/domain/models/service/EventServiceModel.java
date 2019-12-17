package com.project.barfinder.domain.models.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.EventCategory;

import java.time.LocalDateTime;

public class EventServiceModel extends BaseServiceModel {
    private BarServiceModel bar;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;


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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
