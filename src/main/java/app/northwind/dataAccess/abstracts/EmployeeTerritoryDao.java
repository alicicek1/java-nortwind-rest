package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.EmployeeTerritory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTerritoryDao extends JpaRepository<EmployeeTerritory, Integer> {
}
