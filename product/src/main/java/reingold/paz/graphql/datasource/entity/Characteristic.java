package reingold.paz.graphql.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "characteristics")
@Data
public class Characteristic {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
