package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {
}
