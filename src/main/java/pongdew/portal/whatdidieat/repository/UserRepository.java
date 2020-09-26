package pongdew.portal.whatdidieat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pongdew.portal.whatdidieat.model.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
