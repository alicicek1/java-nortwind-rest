package app.northwind.model.entity.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "order_date")
    private int orderDate;

    @Column(name = "required_date")
    private int requiredDate;

    @Column(name = "shipped_date")
    private int shippedDate;

    @Column(name = "ship_via")
    private int shipVia;

    @Column(name = "freight")
    private int freight;

    @Column(name = "ship_name")
    private int shipName;

    @Column(name = "ship_adddress")
    private int shipAddress;

    @Column(name = "ship_city")
    private int shipCity;

    @Column(name = "ship_region")
    private int shipRegion;

    @Column(name = "ship_postal_code")
    private int shipPostalCode;

    @Column(name = "ship_country")
    private int shipCountry;

}
