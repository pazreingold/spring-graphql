package reingold.paz.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import reingold.paz.graphql.datasource.entity.Series;
import reingold.paz.graphql.datasource.generated.SeriesInput;
import reingold.paz.graphql.service.query.SeriesQueryService;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class SeriesResolver {
    private SeriesQueryService seriesQueryService;

    @Autowired
    public SeriesResolver(SeriesQueryService seriesQueryService) {
        this.seriesQueryService = seriesQueryService;
    }

    @DgsQuery
    public List<Series> series(@InputArgument SeriesInput seriesInput) {
        return seriesQueryService.findSeries(Optional.ofNullable(seriesInput));
    }
}
