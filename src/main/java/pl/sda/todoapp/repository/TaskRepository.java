package pl.sda.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.todoapp.model.Status;
import pl.sda.todoapp.model.Task;
import pl.sda.todoapp.model.Type;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(long id);
    List<Task> findByUserIdAndStatus(long id, Status status);
    List<Task> findByUserIdAndType(long id, Type type);
    // void deleteByUserId(long id); <-- nie jest nam potrzebne bo używamy kaskad
}
