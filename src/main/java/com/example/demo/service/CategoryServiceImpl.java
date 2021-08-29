package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAllByName(String name) {
        return categoryRepository.findAllByName(name);
    }

    @Override
    public List<Category> findByNameCategory(String name) {
        return categoryRepository.findByNameCategory(name);
    }

    @Override
    public List<Category> findByNameCategory2(String name) {
        return categoryRepository.findByNameCategory2(name);
    }
}
