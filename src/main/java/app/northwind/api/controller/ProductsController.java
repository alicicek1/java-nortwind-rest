package app.northwind.api.controller;

import app.northwind.business.abstracts.ProductService;
import app.northwind.model.entity.concrete.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping
    public List<Product> get() {
        return this.productService.getAll();
    }
//
//    @GetMapping(name = "/{id}")
//    public Product getById(@PathVariable int id) {
//
//        return productService.
//    }
//
//    @PostMapping
//    public String add() {
//
//    }
//
//    @PutMapping
//    public String update() {
//
//    }
//
//    @DeleteMapping(name = "/{id}")
//    public String delete(@PathVariable int id) {
//
//    }
}
