package cloud.oauth2.server.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cloud.oauth2.server.persistence.entity.LoginHistoryEntity;

public interface LoginHistoryRepository extends JpaRepository<LoginHistoryEntity, Long> {
    Page<LoginHistoryEntity> findByUsername(String username, Pageable page);
}
