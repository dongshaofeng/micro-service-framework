package cloud.resource.admin.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.resource.admin.persistence.entity.RoleEntity;

 

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
//    Page<ResourceEntity> findByUsername(String username, Pageable page);
}