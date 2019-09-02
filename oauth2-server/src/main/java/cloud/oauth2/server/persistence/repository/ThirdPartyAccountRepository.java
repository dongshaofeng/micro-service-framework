package cloud.oauth2.server.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.oauth2.server.persistence.entity.ThirdPartyAccountEntity;

public interface ThirdPartyAccountRepository extends JpaRepository<ThirdPartyAccountEntity, Long> {
    ThirdPartyAccountEntity findByThirdPartyAndThirdPartyAccountId(String thirdParty, String thirdPartyAccountId);
}
