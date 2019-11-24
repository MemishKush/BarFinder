package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.CategoryServiceModel;
import com.project.barfinder.repository.CategoryRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryServiceModel addCategory(CategoryServiceModel categoryServiceModel) {
        return null;
    }

    @Override
    public List<CategoryServiceModel> findAllCategories() {
        return null;
    }
}
