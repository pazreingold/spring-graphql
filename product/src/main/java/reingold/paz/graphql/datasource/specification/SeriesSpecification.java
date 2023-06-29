package reingold.paz.graphql.datasource.specification;

import org.springframework.data.jpa.domain.Specification;
import reingold.paz.graphql.datasource.entity.Series;

public class SeriesSpecification extends BaseSpecification {

    public static final String FIELD_NAME = "name";
    public static final String FIELD_MANUFACTURER = "manufacturer";

    public static Specification<Series> seriesNameContainsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(FIELD_NAME)),
                contains(keyword.toLowerCase())
        );
    }

    public static Specification<Series> manufacturerNameContainsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) -> {
            var joinManufacturer = root.join(FIELD_MANUFACTURER);

            return criteriaBuilder.like(
                    criteriaBuilder.lower(joinManufacturer.get(
                            ManufacturerSpecification.FIELD_NAME
                    )),
                    contains(keyword.toLowerCase())
            );
        };
    }

    public static Specification<Series> manufacturerOriginCountryContainsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) -> {
            var joinManufacturer = root.join(FIELD_MANUFACTURER);

            return criteriaBuilder.like(
                    criteriaBuilder.lower(joinManufacturer.get(
                            ManufacturerSpecification.FIELD_ORIGIN_COUNTRY
                    )),
                    contains(keyword.toLowerCase())
            );
        };
    }

}
