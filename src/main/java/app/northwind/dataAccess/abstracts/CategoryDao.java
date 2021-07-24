package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
