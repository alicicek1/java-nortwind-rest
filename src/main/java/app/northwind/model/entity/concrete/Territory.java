package app.northwind.model.entity.concrete;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "territories")
@AllArgsConstructor
@NoArgsConstructor
public class Territory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "territory_id")
    private int id;

    @Column(name = "territory_description")
    private int territoryDescription;

    @Column(name = "region_id")
    private int regionId;
}
