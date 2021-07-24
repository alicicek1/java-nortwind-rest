package app.northwind.api.controller;

import app.northwind.business.abstracts.ProductService;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.model.entity.concrete.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @GetMapping(path = "/{id}")
    public DataResult<Product> getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    }, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public DataResult<Product> add(@RequestBody Product data) {
        return this.productService.add(data);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    }, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public DataResult<Product> update(@RequestBody Product data) {
        return productService.update(data);
    }

    @DeleteMapping(path = "/{id}")
    public Result delete(@PathVariable int id) {
        return productService.delete(id);
    }
}
