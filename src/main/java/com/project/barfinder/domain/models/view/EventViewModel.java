package com.project.barfinder.domain.models.view;

import com.project.barfinder.domain.entities.Bar;

import java.time.LocalDateTime;

public class EventViewModel {
    private Bar bar;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;

    public EventViewModel() {
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
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
