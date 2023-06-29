package reingold.paz.graphql.datasource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import reingold.paz.graphql.datasource.entity.Manufacturer;

import java.util.UUID;

@Repository
public interface ManufacturerRepository extends
        JpaRepository<Manufacturer, UUID>, JpaSpecificationExecutor<Manufacturer> {
}
