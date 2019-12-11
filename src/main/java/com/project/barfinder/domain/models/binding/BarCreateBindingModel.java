package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Event;
import com.project.barfinder.domain.entities.MusicStyle;
import com.project.barfinder.domain.entities.PriceRange;

import java.util.List;

public class BarCreateBindingModel {
    private String name;
    private String location;
    private String phoneNumber;
    private String photos;
    private String description;
    private PriceRange priceRange;
    private MusicStyle musicStyle;

    public BarCreateBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public MusicStyle getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(MusicStyle musicStyle) {
        this.musicStyle = musicStyle;
    }
}
