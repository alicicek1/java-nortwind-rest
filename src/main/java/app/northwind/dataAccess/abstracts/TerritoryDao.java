package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.Territory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryDao extends JpaRepository<Territory, Integer> {
}
