package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
