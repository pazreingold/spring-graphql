package reingold.paz.graphql.datasource.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import reingold.paz.graphql.datasource.entity.Model;
import reingold.paz.graphql.datasource.generated.Transmission;

import java.util.ArrayList;
import java.util.List;

public class ModelSpecification extends BaseSpecification {

    public static final String FIELD_NAME = "name";
    public static final String FIELD_TRANSMISSION = "transmission";
    public static final String FIELD_IS_AVAILABLE = "isAvailable";
    public static final String FIELD_SERIES = "series";

    public static final String FIELD_EXTERIOR_COLOR = "exteriorColor";

    private static final String FIELD_ON_THE_ROAD_PRICE = "onTheRoadPrice";

    public static Specification<Model> modelNameContainsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(FIELD_NAME)),
                contains(keyword.toLowerCase())
        );
    }

    public static Specification<Model> available(Boolean isAvailable) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(FIELD_IS_AVAILABLE),
                isAvailable
        );
    }

    public static Specification<Model> transmissionEquals(Transmission transmission) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(FIELD_TRANSMISSION),
                transmission.toString()
        );
    }

    public static Specification<Model> seriesNameContainsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) -> {
            var joinSeries = root.join(FIELD_SERIES);

            return criteriaBuilder.like(
                    criteriaBuilder.lower(joinSeries.get(
                            SeriesSpecification.FIELD_NAME
                    )),
                    contains(keyword.toLowerCase())
            );
        };
    }

    public static Specification<Model> manufacturerNameContainsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) -> {
            var joinManufacturer = root.join(FIELD_SERIES)
                    .join(SeriesSpecification.FIELD_MANUFACTURER);

            return criteriaBuilder.like(
                    criteriaBuilder.lower(
                            joinManufacturer.get(ManufacturerSpecification.FIELD_NAME)
                    ),
                    contains(keyword.toLowerCase())
            );
        };
    }

    public static Specification<Model> manufacturerOriginCountryContainsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) -> {
            var joinManufacturer = root.join(FIELD_SERIES)
                    .join(SeriesSpecification.FIELD_MANUFACTURER);

            return criteriaBuilder.like(
                    criteriaBuilder.lower(
                            joinManufacturer.get(ManufacturerSpecification.FIELD_ORIGIN_COUNTRY)
                    ),
                    contains(keyword.toLowerCase())
            );
        };
    }

    public static Specification<Model> exteriorColorsLikeIgnoreCase(List<String> exteriorColors) {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

            for (var exteriorColor : exteriorColors) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get(FIELD_EXTERIOR_COLOR)),
                                contains(exteriorColor.toLowerCase())
                        )
                );
            }

            return criteriaBuilder.or(
                    predicates.toArray(new Predicate[] {})
            );
        };
    }

    public static Specification<Model> priceGreaterThanEquals(int value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                root.get(FIELD_ON_THE_ROAD_PRICE),
                value
        );
    }

    public static Specification<Model> priceLessThanEquals(int value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
                root.get(FIELD_ON_THE_ROAD_PRICE),
                value
        );
    }

    public static Specification<Model> priceBetween(int value, int highValue) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(
                root.get(FIELD_ON_THE_ROAD_PRICE),
                value, highValue
        );
    }

}
