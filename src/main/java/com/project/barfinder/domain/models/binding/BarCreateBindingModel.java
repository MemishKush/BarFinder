package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Event;

import java.util.List;

public class BarCreateBindingModel {
    private String name;
    private String location;
    private String phoneNumber;
    private String photos;
    private String barCard;
    private String description;
    private String priceRange;

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

    public String getBarCard() {
        return barCard;
    }

    public void setBarCard(String barCard) {
        this.barCard = barCard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
