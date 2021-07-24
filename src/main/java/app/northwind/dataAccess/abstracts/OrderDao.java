package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
