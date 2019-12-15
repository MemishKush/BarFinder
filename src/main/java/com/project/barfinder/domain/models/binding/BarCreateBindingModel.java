package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Category;
import com.project.barfinder.domain.entities.Event;
import com.project.barfinder.domain.entities.MusicStyle;
import com.project.barfinder.domain.entities.PriceRange;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class BarCreateBindingModel {
    private String name;
    private String location;
    private String phoneNumber;
    private List<MultipartFile> images;
    private String description;
    private String address;
    private PriceRange priceRange;
    private MusicStyle musicStyle;
    private Category category;


    public BarCreateBindingModel() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
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
