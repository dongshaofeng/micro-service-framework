package cloud.resource.admin.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.resource.admin.persistence.entity.UserAccountEntity;
 

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
//    Page<ResourceEntity> findByUsername(String username, Pageable page);
}