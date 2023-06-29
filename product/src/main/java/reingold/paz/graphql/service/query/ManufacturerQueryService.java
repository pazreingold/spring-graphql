package reingold.paz.graphql.service.query;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import reingold.paz.graphql.datasource.entity.Manufacturer;
import reingold.paz.graphql.datasource.generated.ManufacturerInput;
import reingold.paz.graphql.datasource.repository.ManufacturerRepository;
import reingold.paz.graphql.datasource.specification.ManufacturerSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerQueryService {
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerQueryService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> findManufacturers(Optional<ManufacturerInput> input) {
        var manufacturerInput = input.orElse(new ManufacturerInput());
        var specification = Specification.where(
                StringUtils.isNotBlank(manufacturerInput.getName()) ?
                        ManufacturerSpecification.nameContainsIgnoreCase(manufacturerInput.getName()) :
                        null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getOriginCountry()) ?
                        ManufacturerSpecification.originCountryContainsIgnoreCase(manufacturerInput.getOriginCountry()) :
                        null
        );

        return manufacturerRepository.findAll(specification);
    }

}
