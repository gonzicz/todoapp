package pl.sda.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.todoapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
