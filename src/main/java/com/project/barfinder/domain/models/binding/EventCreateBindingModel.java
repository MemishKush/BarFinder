package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.EventCategory;

public class EventCreateBindingModel {
    private String barName;
    private String title;
    private String startTime;
    private String endTime;
    private String description;
    private EventCategory eventCategory;

    public EventCreateBindingModel() {
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String bar) {
        this.barName = bar;
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

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }
}
