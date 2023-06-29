package reingold.paz.graphql.service.query;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reingold.paz.graphql.datasource.entity.Model;
import reingold.paz.graphql.datasource.generated.ManufacturerInput;
import reingold.paz.graphql.datasource.generated.ModelInput;
import reingold.paz.graphql.datasource.generated.SeriesInput;
import reingold.paz.graphql.datasource.repository.ModelRepository;
import reingold.paz.graphql.datasource.specification.ModelSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class ModelQueryService {
    private ModelRepository modelRepository;

    @Autowired
    public ModelQueryService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> findModels(Optional<ModelInput> input) {
        var modelInput = input.orElse(new ModelInput());
        var seriesInput = modelInput.getSeries() == null ? new SeriesInput()
                : modelInput.getSeries();
        var manufacturerInput = seriesInput.getManufacturer() == null ?
                new ManufacturerInput() : seriesInput.getManufacturer();

        var specification = Specification.where(
                StringUtils.isNotBlank(manufacturerInput.getName()) ?
                        ModelSpecification.manufacturerNameContainsIgnoreCase(
                                manufacturerInput.getName()
                        ) : null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getOriginCountry()) ?
                        ModelSpecification.manufacturerOriginCountryContainsIgnoreCase(
                                manufacturerInput.getOriginCountry()
                        ) : null
        ).and(
                StringUtils.isNotBlank(seriesInput.getName()) ?
                        ModelSpecification.seriesNameContainsIgnoreCase(
                                seriesInput.getName()
                        ) : null
        ).and(
                StringUtils.isNotBlank(modelInput.getName()) ?
                        ModelSpecification.modelNameContainsIgnoreCase(
                                modelInput.getName()
                        ) : null
        ).and(
                modelInput.getIsAvailable() != null ?
                        ModelSpecification.available(modelInput.getIsAvailable())
                        : null
        ).and(
                modelInput.getTransmission() != null ?
                        ModelSpecification.transmissionEquals(modelInput.getTransmission())
                        : null
        ).and(
                !CollectionUtils.isEmpty(modelInput.getExteriorColors()) ?
                        ModelSpecification.exteriorColorsLikeIgnoreCase(modelInput.getExteriorColors())
                        : null
        );

        return modelRepository.findAll(specification);
    }
}
