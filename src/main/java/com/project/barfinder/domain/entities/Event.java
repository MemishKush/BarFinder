package com.project.barfinder.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event extends BaseEntity {
    private Bar bar;
    private String title;
    private String startTime;
    private String endTime;
    private String description;
    private EventCategory eventCategory;

    public Event() {
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Bar.class)
    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Column(nullable = false)
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Column(nullable = false)
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
