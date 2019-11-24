package com.project.barfinder.domain.models.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.User;

public class ReservationServiceModel extends BaseServiceModel {
    private UserServiceModel user;
    private BarServiceModel bar;
    private Integer guestCount;
    private String time;
    private String additionalNotes;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
