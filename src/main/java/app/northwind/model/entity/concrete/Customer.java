package app.northwind.model.entity.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null!")
    @Column(name = "customer_id")
    private int id;

    @NotNull(message = "Company name cannot be null!")
    @Column(name = "company_name")
    private String companyName;

    @NotNull(message = "Contact name cannot be null!")
    @Column(name = "contact_name")
    private String contactName;

    @NotNull(message = "Contact title cannot be null!")
    @Column(name = "contact_title")
    private String contactTitle;

    @NotNull(message = "Address cannot be null!")
    @Column(name = "address")
    private String address;

    @NotNull(message = "City cannot be null!")
    @Column(name = "city")
    private String city;


    @Column(name = "region")
    private String region;

    @NotNull(message = "Postal code cannot be null!")
    @Column(name = "postal_code")
    private String postalCode;

    @NotNull(message = "Country cannot be null!")
    @Column(name = "country")
    private String country;

    @NotNull(message = "Phone cannot be null!")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "Fax cannot be null!")
    private String fax;


}
