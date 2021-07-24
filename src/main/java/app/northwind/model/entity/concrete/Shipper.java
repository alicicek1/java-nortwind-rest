package app.northwind.model.entity.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shippers")
@AllArgsConstructor
@NoArgsConstructor
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipper_id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone")
    private String phone;
}
