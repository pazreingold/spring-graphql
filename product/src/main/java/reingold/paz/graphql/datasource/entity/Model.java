package reingold.paz.graphql.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "models")
@Data
public class Model {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    private double onTheRoadPrice;

    private int lengthMm;

    private int widthMm;

    private int heightMm;

    private String exteriorColor;

    private String interiorColor;

    private int releaseYear;

    private String transmission;

    private String bodyType;

    private String fuel;

    private int doors;

    private int airbags;

    private boolean isAvailable;

    @OneToOne
    @JoinColumn(name = "engine_uuid")
    private Engine engine;

    @OneToMany
    @JoinColumn(name = "model_uuid")
    private List<Feature> features;

    @ManyToOne()
    @JoinColumn(name = "series_uuid")
    private Series series;
}
