package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao extends JpaRepository<Supplier, Integer> {
}
