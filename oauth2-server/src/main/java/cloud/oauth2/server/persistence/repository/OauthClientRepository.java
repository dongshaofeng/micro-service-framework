package cloud.oauth2.server.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.oauth2.server.persistence.entity.OauthClientEntity;

public interface OauthClientRepository extends JpaRepository<OauthClientEntity, Long> {
    OauthClientEntity findByClientId(String clientId);
}
