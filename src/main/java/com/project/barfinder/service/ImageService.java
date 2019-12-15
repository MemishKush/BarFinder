package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.ImageServiceModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    ImageServiceModel addImage(String barId, MultipartFile multipartFile);
}
