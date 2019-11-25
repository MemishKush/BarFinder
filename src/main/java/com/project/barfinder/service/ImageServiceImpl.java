package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Image;
import com.project.barfinder.domain.models.service.ImageServiceModel;
import com.project.barfinder.repository.ImageRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
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
        return this.modelMapper.map(this.imageRepository.save(this.modelMapper.map(imageServiceModel, Image.class)),ImageServiceModel.class);
    }

    @Override
    public List<ImageServiceModel> findAllImages() {
         List<ImageServiceModel> serviceModels = new ArrayList<>();
         List<Image> imagesFromDb = this.imageRepository.findAll();
        for (Image image : imagesFromDb) {
            ImageServiceModel mappedServiceModels = this.modelMapper.map(image,ImageServiceModel.class);
            serviceModels.add(mappedServiceModels);
        }
        return serviceModels;
    }

    @Override
    public ImageServiceModel findByUrl(String url) {
        return this.modelMapper.map(imageRepository.findByUrl(url),ImageServiceModel.class);
    }
}
