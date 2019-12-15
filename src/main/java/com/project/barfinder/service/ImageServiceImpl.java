package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.Image;
import com.project.barfinder.domain.models.service.ImageServiceModel;
import com.project.barfinder.repository.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;
    private final BarService barService;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, CloudinaryService cloudinaryService, ModelMapper modelMapper, BarService barService) {
        this.imageRepository = imageRepository;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
        this.barService = barService;
    }

    @Override
    public ImageServiceModel addImage(String barId, MultipartFile multipartFile) {
        Bar barFromDb = ((BarServiceImpl) this.barService).getBarByIdInternal(barId);

        try {
            String result = this.cloudinaryService.uploadImage(multipartFile);
            Image image = new Image();
            image.setBar(barFromDb);
            image.setUrl(result);
            this.imageRepository.save(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
