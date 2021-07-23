package app.northwind.business.abstracts;

import app.northwind.model.entity.concrete.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
