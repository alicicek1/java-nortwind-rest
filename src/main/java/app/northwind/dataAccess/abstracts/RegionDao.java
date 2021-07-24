package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionDao extends JpaRepository<Region, Integer> {
}
