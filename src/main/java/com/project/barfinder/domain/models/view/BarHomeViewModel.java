package com.project.barfinder.domain.models.view;

import com.project.barfinder.domain.entities.Category;
import com.project.barfinder.domain.entities.MusicStyle;
import com.project.barfinder.domain.entities.PriceRange;
import com.project.barfinder.domain.models.service.ImageServiceModel;

public class BarHomeViewModel {
    private String id;

    private String name;

    private String description;

    private PriceRange priceRange;

    private MusicStyle musicStyle;

    private Category category;

    // TODO: Make View Model
    private ImageServiceModel thumbnail;

    public BarHomeViewModel() {
    }

public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ImageServiceModel getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageServiceModel thumbnail) {
        this.thumbnail = thumbnail;
    }
}
