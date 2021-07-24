package app.northwind.api.controller;

import app.northwind.business.abstracts.CategoryService;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.model.entity.concrete.Category;
import app.northwind.model.entity.concrete.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public DataResult<List<Category>> getall() {
        return categoryService.getAll();
    }

    public DataResult<Product> getById(@PathVariable int id) {
        return null;
    }
}
