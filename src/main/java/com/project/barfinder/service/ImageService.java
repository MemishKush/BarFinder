package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.ImageServiceModel;

import java.util.List;

public interface ImageService {
    ImageServiceModel addImage(ImageServiceModel imageServiceModel);
    List<ImageServiceModel> findAllImages();
    ImageServiceModel findByUrl(String url);
}
