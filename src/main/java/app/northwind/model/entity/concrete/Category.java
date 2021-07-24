package app.northwind.model.entity.concrete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @NotNull(message = "Id cannot be null!")
    private int id;

    @Column(name = "category_name")
    @NotNull(message = "Category name cannot be null!")
    private String categoryName;

    @Column(name = "description")
    @NotNull(message = "Description cannot be null!")
    private String description;

    @JsonIgnoreProperties(value = "applications,hibernateLazyInitializer")
    @Column(name = "picture")
    private byte[] picture;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList;
}
