package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Category;
import com.project.barfinder.domain.models.service.CategoryServiceModel;
import com.project.barfinder.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryServiceModel addCategory(CategoryServiceModel categoryServiceModel) {
        return this.modelMapper.map(this.categoryRepository.save(this.modelMapper.map(categoryServiceModel, Category.class)), CategoryServiceModel.class);
    }

    @Override
    public List<CategoryServiceModel> findAllCategories() {
        List<CategoryServiceModel> serviceModels = new ArrayList<>();
        List<Category> categoriesFromDb = this.categoryRepository.findAll();
        for (Category category : categoriesFromDb) {
            CategoryServiceModel mappedServiceModels = this.modelMapper.map(category, CategoryServiceModel.class);
            serviceModels.add(mappedServiceModels);
        }
        return serviceModels;
    }

    @Override
    public CategoryServiceModel findByName(String name) {
        return this.modelMapper.map(categoryRepository.findByName(name), CategoryServiceModel.class);
    }

    @Override
    public void deleteCategory(String id) {
        this.categoryRepository.deleteById(id);

    }

    @Override
    public CategoryServiceModel editCategory(CategoryServiceModel categoryServiceModel) {
        return this.modelMapper.map(categoryRepository.saveAndFlush(this.modelMapper.map(categoryServiceModel, Category.class)), CategoryServiceModel.class);
    }
}
