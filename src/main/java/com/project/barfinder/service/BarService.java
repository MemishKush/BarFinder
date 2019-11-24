package com.project.barfinder.service;


import com.project.barfinder.domain.models.service.BarServiceModel;

import java.util.List;

public interface BarService {
    BarServiceModel addBar(BarServiceModel barServiceModel);

    List<BarServiceModel> findAllBars();

    BarServiceModel findById(String id);
    List<BarServiceModel> findByMusicStyle(String musicStyle);
    List<BarServiceModel> findByCategory(String category);
    BarServiceModel findByName(String name);
    BarServiceModel editBar(BarServiceModel barServiceModel);

    void deleteBar(String id);
}
