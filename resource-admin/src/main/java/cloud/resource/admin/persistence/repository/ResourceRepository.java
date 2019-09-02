package cloud.resource.admin.persistence.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import cloud.resource.admin.persistence.entity.ResourceEntity;


public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
//    Page<ResourceEntity> findByUsername(String username, Pageable page);
}