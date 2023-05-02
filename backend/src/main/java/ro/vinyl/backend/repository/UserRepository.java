package ro.vinyl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.vinyl.backend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
