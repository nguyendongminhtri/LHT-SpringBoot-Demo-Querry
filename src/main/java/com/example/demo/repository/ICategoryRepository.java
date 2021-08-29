package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    //Tim kiếm chính xác
    List<Category> findAllByName(String name);
    @Query("select c from Category  as c where c.name like :name1")
    List<Category> findByNameCategory2( String name1);
    //Tìm kiếm gần đúng
    List<Category> findAllByNameContaining(String name);
    @Query("select c from Category as c where c.name like concat('%',:name,'%') ")
    List<Category> findByNameCategory(String name);
}
