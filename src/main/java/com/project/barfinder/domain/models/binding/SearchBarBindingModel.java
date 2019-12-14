package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Category;
import com.project.barfinder.domain.entities.MusicStyle;
import com.project.barfinder.domain.entities.PriceRange;

public class SearchBarBindingModel {
    private Category category;
    private MusicStyle musicStyle;
    private PriceRange priceRange;

    public SearchBarBindingModel() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MusicStyle getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(MusicStyle musicStyle) {
        this.musicStyle = musicStyle;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }
}
