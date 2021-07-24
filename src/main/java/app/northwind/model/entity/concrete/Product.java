package app.northwind.model.entity.concrete;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @NotNull(message = "Id cannot be null!")
    private int id;

    /*
    @Column(name = "category_id")
    @NotNull(message = "Category info cannot be null!")
    private int categoryId;
    */

    @Column(name = "product_name")
    @NotNull(message = "Product name cannot be null!")
    @Size(min = 3, message = "Product name must be at least 2 character!")
    private String productName;

    @Column(name = "unit_price")
    @NotNull(message = "Unit price cannot be null!")
    private double unitPrice;

    @Column(name = "units_in_stock")
    @NotNull(message = "Units in stock cannot be null!")
    private short unitsInStock;

    @Column(name = "quantity_per_unit")
    @NotNull(message = "Quantity cannot be null!")
    private String quantityPerUnit;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
