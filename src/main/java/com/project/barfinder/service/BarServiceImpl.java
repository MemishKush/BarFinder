package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.models.service.BarServiceModel;
import com.project.barfinder.domain.models.service.BaseServiceModel;
import com.project.barfinder.repository.BarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarServiceImpl implements BarService {
    private final BarRepository barRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BarServiceImpl(BarRepository barRepository, ModelMapper modelMapper) {
        this.barRepository = barRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BarServiceModel addBar(BarServiceModel barServiceModel) {
        return this.modelMapper.map(this.barRepository.save(this.modelMapper.map(barServiceModel, Bar.class)), BarServiceModel.class);
    }

    @Override
    public List<BarServiceModel> findAllBars() {
        List<BarServiceModel> serviceModels = new ArrayList<>();
        List<Bar> barsFromDb = this.barRepository.findAll();
        for (Bar bar : barsFromDb) {
            BarServiceModel mappedServiceModel = this.modelMapper.map(bar, BarServiceModel.class);
            serviceModels.add(mappedServiceModel);
        }
        return serviceModels;
    }

    @Override
    public BarServiceModel findById(String id) {
        return this.modelMapper.map(barRepository.findById(id), BarServiceModel.class);
    }

    @Override
    public List<BarServiceModel> findByMusicStyle(String musicStyle) {
        List<BarServiceModel> serviceModels = new ArrayList<>();
        List<Bar> barsFromDb = this.barRepository.findByMusicStyle(musicStyle);
        for (Bar bar : barsFromDb) {
            BarServiceModel mappedServiceModel = this.modelMapper.map(bar, BarServiceModel.class);
            serviceModels.add(mappedServiceModel);
        }
        return serviceModels;
    }

    @Override
    public List<BarServiceModel> findByCategory(String category) {
       List<BarServiceModel> serviceModels = new ArrayList<>();
       List<Bar> barsFromDb = this.barRepository.findByCategory(category);
        for (Bar bar : barsFromDb) {
            BarServiceModel mappedServiceModel = this.modelMapper.map(bar,BarServiceModel.class);
            serviceModels.add(mappedServiceModel);
        }
        return serviceModels;
    }

    @Override
    public void deleteBar(String id) {
        this.barRepository.deleteById(id);
    }
}
