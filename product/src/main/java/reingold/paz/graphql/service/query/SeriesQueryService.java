package reingold.paz.graphql.service.query;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import reingold.paz.graphql.datasource.entity.Series;
import reingold.paz.graphql.datasource.generated.ManufacturerInput;
import reingold.paz.graphql.datasource.generated.SeriesInput;
import reingold.paz.graphql.datasource.repository.SeriesRepository;
import reingold.paz.graphql.datasource.specification.SeriesSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesQueryService {
    private SeriesRepository seriesRepository;

    @Autowired
    public SeriesQueryService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public List<Series> findSeries(Optional<SeriesInput> input) {
        var seriesInput = input.orElse(new SeriesInput());
        var manufacturerInput = seriesInput.getManufacturer() == null ?
                new ManufacturerInput() : seriesInput.getManufacturer();
        var specification = Specification.where(
                StringUtils.isNotBlank(seriesInput.getName()) ?
                        SeriesSpecification.seriesNameContainsIgnoreCase(seriesInput.getName()) :
                        null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getName()) ?
                        SeriesSpecification.manufacturerNameContainsIgnoreCase(manufacturerInput.getName()) :
                        null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getOriginCountry()) ?
                        SeriesSpecification.manufacturerOriginCountryContainsIgnoreCase(manufacturerInput.getOriginCountry()) :
                        null
        );

        return seriesRepository.findAll(specification);
    }
}
