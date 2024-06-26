package com.unimarket.unimarket.controller;

import com.unimarket.unimarket.application.category.CreateCategoryUseCaseImpl;
import com.unimarket.unimarket.application.category.DeleteCategoryUseCaseImpl;
import com.unimarket.unimarket.core.cases.category.FindAllCategoriesUseCase;
import com.unimarket.unimarket.core.entities.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CreateCategoryUseCaseImpl createCategory;
    private final DeleteCategoryUseCaseImpl deleteCategory;
    private final FindAllCategoriesUseCase findAllCategories;

    @Autowired
    public CategoryController(CreateCategoryUseCaseImpl createCategory, DeleteCategoryUseCaseImpl deleteCategory, FindAllCategoriesUseCase findAllCategories) {
        this.createCategory = createCategory;
        this.deleteCategory = deleteCategory;
        this.findAllCategories = findAllCategories;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = this.findAllCategories.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping()
    public ResponseEntity<Category> create(@RequestBody Category category, UriComponentsBuilder uriBuilder) {
        Category response = this.createCategory.create(category);
        URI uri = uriBuilder.path("/category/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{categoryName}")
    public ResponseEntity delete(@PathVariable String categoryName) {
        this.deleteCategory.delete(categoryName);
        return ResponseEntity.noContent().build();
    }

}