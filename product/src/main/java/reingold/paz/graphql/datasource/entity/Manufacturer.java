package reingold.paz.graphql.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "manufacturers")
@Data
public class Manufacturer {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    private String originCountry;

    private String description;

    @OneToMany(mappedBy = "manufacturer")
    private List<Series> series;
}
