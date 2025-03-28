package database.repository;

import database.entity.CryptMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<CryptMessageEntity, Long>{
}
