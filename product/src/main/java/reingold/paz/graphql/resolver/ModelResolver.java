package reingold.paz.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import reingold.paz.graphql.datasource.entity.Model;
import reingold.paz.graphql.datasource.generated.ModelInput;
import reingold.paz.graphql.service.query.ModelQueryService;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class ModelResolver {
    private ModelQueryService modelQueryService;

    @Autowired
    public ModelResolver(ModelQueryService modelQueryService) {
        this.modelQueryService = modelQueryService;
    }

    @DgsQuery
    public List<Model> models(@InputArgument ModelInput modelInput) {
        return modelQueryService.findModels(Optional.ofNullable(modelInput));
    }
}
