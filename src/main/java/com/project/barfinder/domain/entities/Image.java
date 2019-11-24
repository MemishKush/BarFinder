package com.project.barfinder.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image extends BaseEntity {
    private String url;

    private Bar bar;

    public Image() {
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Bar.class)
    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}
