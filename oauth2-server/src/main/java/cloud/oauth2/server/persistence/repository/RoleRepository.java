package cloud.oauth2.server.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.oauth2.server.persistence.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRoleName(String roleName);
}
