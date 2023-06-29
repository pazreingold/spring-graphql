package reingold.paz.graphql.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "series")
@Data
public class Series {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    @OneToMany
    @JoinColumn(name = "series_uuid")
    private List<Characteristic> characteristics;

    @OneToMany(mappedBy = "series")
    private List<Model> models;

    @ManyToOne
    @JoinColumn(name = "manufacturer_uuid")
    private Manufacturer manufacturer;

}
