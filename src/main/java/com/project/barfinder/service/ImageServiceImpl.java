package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.ImageServiceModel;
import com.project.barfinder.repository.ImageRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;

    public ImageServiceImpl(ImageRepository imageRepository, ModelMapper modelMapper) {
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ImageServiceModel addImage(ImageServiceModel imageServiceModel) {
        return null;
    }

    @Override
    public List<ImageServiceModel> findAllImages() {
        return null;
    }
}
