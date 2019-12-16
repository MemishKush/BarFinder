package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ReservationCreateBindingModel {
    private String bar;
    private Integer guestCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime time;
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
}
