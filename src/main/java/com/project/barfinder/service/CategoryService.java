package com.project.barfinder.service;

import java.util.List;

public interface CategoryService {
    CategoryServiceModel addCategory(CategoryServiceModel categoryServiceModel);
    List<CategoryServiceModel> findAllCategories();
    CategoryServiceModel findByName(String name);
    void deleteCategory(String id);
    CategoryServiceModel editCategory(CategoryServiceModel categoryServiceModel);
}
