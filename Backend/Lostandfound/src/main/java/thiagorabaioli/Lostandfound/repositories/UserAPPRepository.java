package thiagorabaioli.Lostandfound.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thiagorabaioli.Lostandfound.entities.UserAPP;

@Repository
public interface UserAPPRepository extends JpaRepository<UserAPP, Long> {
}
