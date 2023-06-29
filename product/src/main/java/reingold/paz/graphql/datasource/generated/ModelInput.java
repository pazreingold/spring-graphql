package reingold.paz.graphql.datasource.generated;

import lombok.Data;

import java.util.List;

@Data
public class ModelInput {
    SeriesInput series;
    String name;
    Boolean isAvailable;
    Transmission transmission;
    List<String> exteriorColors;
}
