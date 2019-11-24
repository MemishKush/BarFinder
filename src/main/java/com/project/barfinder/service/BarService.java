package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.BarServiceModel;

import java.util.List;

public interface BarService {
    BarServiceModel addBar(BarServiceModel barServiceModel);

    List<BarServiceModel> findAllBars();

    BarServiceModel findById(String id);

    void deleteBar(String id);
}
