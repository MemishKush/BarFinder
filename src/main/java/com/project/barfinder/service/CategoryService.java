package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.CategoryServiceModel;

import java.util.List;

public interface CategoryService {
    CategoryServiceModel addCategory(CategoryServiceModel categoryServiceModel);
    List<CategoryServiceModel> findAllCategories();
}
