package app.northwind.model.entity.concrete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    @NotNull(message = "EmployeeId cannot be null!")
    private int id;

    @NotNull(message = "Last name cannot be null!")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "First name cannot be null!")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Title cannot be null!")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Title of courtesy cannot be null!")
    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;

    @NotNull(message = "Birth date cannot be null!")
    @Column(name = "birth_date")
    private Date birthDate;

    @NotNull(message = "Hire daate cannot be null!")
    @Column(name = "hire_date")
    private Date hireDate;

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

    @NotNull(message = "Home phone cannot be null!")
    @Column(name = "home_phone")
    private String homePhone;

    @NotNull(message = "Extension cannot be null!")
    @Column(name = "extension")
    private String extension;

    @JsonIgnoreProperties(value = "applications,hibernaLazyInitializer")
    @Column(name = "photo")
    private byte[] photo;


    @Column(name = "notes")
    private String notes;


    @Column(name = "reports_to")
    private int reportsTo;

    @NotNull(message = "Photo path cannot be null!")
    @Column(name = "photo_path")
    private String photoPath;
}
