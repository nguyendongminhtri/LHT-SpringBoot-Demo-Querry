package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Category save(Category category);
    void deleteById(Long id);
    Optional<Category> findById(Long id);
    List<Category> findAllByName(String name);
    List<Category> findByNameCategory(String name);
    List<Category> findByNameCategory2(String name);
}
