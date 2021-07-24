package app.northwind.model.entity.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_territories")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTerritory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @Column(name = "territory_id")
    private int territoryId;
}
