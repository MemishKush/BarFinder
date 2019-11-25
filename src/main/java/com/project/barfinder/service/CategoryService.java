package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.CategoryServiceModel;

import java.util.List;

public interface CategoryService {
    CategoryServiceModel addCategory(CategoryServiceModel categoryServiceModel);
    List<CategoryServiceModel> findAllCategories();
    CategoryServiceModel findByName(String name);
    void deleteCategory(String id);
    CategoryServiceModel editCategory(CategoryServiceModel categoryServiceModel);
}
