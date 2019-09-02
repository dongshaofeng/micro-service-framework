package cloud.oauth2.server.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cloud.oauth2.server.persistence.entity.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
    UserAccountEntity findByUsername(String username);

    Page<UserAccountEntity> findByUsernameLike(String username, Pageable page);

    boolean existsByUsername(String username);
}
