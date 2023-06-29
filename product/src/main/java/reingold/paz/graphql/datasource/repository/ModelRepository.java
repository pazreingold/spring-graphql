package reingold.paz.graphql.datasource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import reingold.paz.graphql.datasource.entity.Model;

import java.util.UUID;

@Repository
public interface ModelRepository extends
        JpaRepository<Model, UUID>, JpaSpecificationExecutor<Model> {
}
