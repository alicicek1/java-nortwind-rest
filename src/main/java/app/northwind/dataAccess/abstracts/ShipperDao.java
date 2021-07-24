package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperDao extends JpaRepository<Shipper, Integer> {
}
