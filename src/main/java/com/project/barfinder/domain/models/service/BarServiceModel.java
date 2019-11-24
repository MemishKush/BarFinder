package com.project.barfinder.domain.models.service;

import com.project.barfinder.domain.entities.Event;

import java.util.List;

public class BarServiceModel extends BaseServiceModel {

    private String name;
    private String location;
    private String address;
    private String phoneNumber;
    private List<ImageServiceModel> photos;
    private String description;
    private String priceRange;
    private String musicStyle;
    private List<Event> events;
    private List<ReservationServiceModel> reservations;
    private List<ReviewServiceModel> reviews;
    private CategoryServiceModel category;

    public BarServiceModel() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ImageServiceModel> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ImageServiceModel> photos) {
        this.photos = photos;
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

    public String getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(String musicStyle) {
        this.musicStyle = musicStyle;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<ReservationServiceModel> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationServiceModel> reservations) {
        this.reservations = reservations;
    }

    public List<ReviewServiceModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewServiceModel> reviews) {
        this.reviews = reviews;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }
}
