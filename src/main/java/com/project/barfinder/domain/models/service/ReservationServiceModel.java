package com.project.barfinder.domain.models.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.User;

import java.time.LocalDateTime;

public class ReservationServiceModel extends BaseServiceModel {
    private UserServiceModel user;
    private BarServiceModel bar;
    private Integer guestCount;
    private LocalDateTime time;
    private String additionalNotes;
    private boolean isApproved;

    public ReservationServiceModel() {
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }

    public BarServiceModel getBar() {
        return bar;
    }

    public void setBar(BarServiceModel bar) {
        this.bar = bar;
    }

    public Integer getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
