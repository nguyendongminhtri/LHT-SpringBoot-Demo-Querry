package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.response.ResponseMessage;
import com.example.demo.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("category")
@RestController
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;
    @GetMapping
    public ResponseEntity<?> listCategory(){
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        if(category.getName().trim().isEmpty()){
            return new ResponseEntity<>(new ResponseMessage("The name is required!"), HttpStatus.OK);
        }
        categoryService.save(category);
        return new ResponseEntity<>(new ResponseMessage("yes"),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category){
        Optional<Category> category1 = categoryService.findById(id);
        if(!category1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(category.getName().trim().isEmpty()){
            return new ResponseEntity<>(new ResponseMessage("The name is required!"), HttpStatus.OK);
        }
        category1.get().setName(category.getName());
        categoryService.save(category1.get());
        return new ResponseEntity<>(new ResponseMessage("update success"), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> detailCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @GetMapping("/search")
    public  ResponseEntity<?> searchByName(@RequestParam("search") String name){
        if(name.trim().isEmpty()){
            return new ResponseEntity<>(new ResponseMessage("The name is required"), HttpStatus.OK);
        } else {
            List<Category> categories = categoryService.findByNameCategory2(name);
            if(categories.isEmpty()){
                return new ResponseEntity<>(new ResponseMessage("NOT FOUND"), HttpStatus.OK);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
//        List<Category> categories = categoryService.findAllByNameContaining(name);

    }

}
