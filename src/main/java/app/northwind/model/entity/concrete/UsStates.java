package app.northwind.model.entity.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "us_states")
@AllArgsConstructor
@NoArgsConstructor
public class UsStates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private int id;

    @Column(name = "state_name")
    private int stateName;

    @Column(name = "state_abbr")
    private int stateAbbr;

    @Column(name = "state_region")
    private int stateRegion;
}
