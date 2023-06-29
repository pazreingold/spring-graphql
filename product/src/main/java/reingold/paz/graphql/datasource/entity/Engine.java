package reingold.paz.graphql.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table (name = "engines")
@Data
public class Engine {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String description;
    private int horsePower;


}
