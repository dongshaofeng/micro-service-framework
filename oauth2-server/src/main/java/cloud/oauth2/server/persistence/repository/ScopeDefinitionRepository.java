package cloud.oauth2.server.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.oauth2.server.persistence.entity.ScopeDefinitionEntity;

public interface ScopeDefinitionRepository extends JpaRepository<ScopeDefinitionEntity, Long> {
    ScopeDefinitionEntity findByScope(String scope);
}
