package reingold.paz.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import reingold.paz.graphql.datasource.entity.Manufacturer;
import reingold.paz.graphql.datasource.generated.ManufacturerInput;
import reingold.paz.graphql.service.query.ManufacturerQueryService;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class ManufacturerResolver {
    private ManufacturerQueryService manufacturerQueryService;

    @Autowired
    public ManufacturerResolver(ManufacturerQueryService manufacturerQueryService) {
        this.manufacturerQueryService = manufacturerQueryService;
    }

    @DgsQuery
    public List<Manufacturer> manufacturers(@InputArgument ManufacturerInput manufacturerInput
    ) {
        return manufacturerQueryService.findManufacturers(Optional.ofNullable(manufacturerInput));
    }
}
