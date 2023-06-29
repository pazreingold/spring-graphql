package reingold.paz.graphql.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "features")
@Data
public class Feature {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    private boolean activeByDefault;

    private boolean activeByRequest;

    private int installationPrice;

    private boolean isSafety;

    private boolean isEntertainment;

    private boolean isPerformance;

    private boolean isConvenience;

    private boolean isDisplay;
}
