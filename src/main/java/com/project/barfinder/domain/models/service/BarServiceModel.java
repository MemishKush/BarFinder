package com.project.barfinder.domain.models.service;

import com.project.barfinder.domain.entities.Category;
import com.project.barfinder.domain.entities.Event;
import com.project.barfinder.domain.entities.MusicStyle;
import com.project.barfinder.domain.entities.PriceRange;

import java.util.ArrayList;
import java.util.List;

public class BarServiceModel extends BaseServiceModel {

    private String name;
    private String location;
    private String address;
    private String phoneNumber;
    private List<ImageServiceModel> photos;
    private String description;
    private PriceRange priceRange;
    private MusicStyle musicStyle;
    private List<EventServiceModel> events;
    private List<ReservationServiceModel> reservations;
    private List<ReviewServiceModel> reviews;
    private Category category;

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

    public List<EventServiceModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventServiceModel> events) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
