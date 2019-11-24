package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.User;

public class ReservationCreateBindingModel {
    private String bar;
    private Integer guestCount;
    private String time;
    private String additionalNotes;

    public ReservationCreateBindingModel() {
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
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
