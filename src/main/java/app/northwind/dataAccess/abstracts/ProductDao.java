package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
