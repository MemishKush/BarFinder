package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.BarServiceModel;
import com.project.barfinder.repository.BarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public List<BarServiceModel> findAllBars() {
        return null;
    }

    @Override
    public BarServiceModel findById(String id) {
        return null;
    }

    @Override
    public void deleteBar(String id) {

    }
}
