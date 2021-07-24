package app.northwind.dataAccess.abstracts;

import app.northwind.model.entity.concrete.UsStates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsStatesDao extends JpaRepository<UsStates, Integer> {
}
