package pl.sda.todoapp.service;

import org.springframework.stereotype.Service;
import pl.sda.todoapp.model.Status;
import pl.sda.todoapp.model.Task;
import pl.sda.todoapp.model.Type;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasksUser(long userID) {
        return taskRepository.findByUserId(userID);
    }

    public List<Task> getAllTasksUserByStatus(long id, Status status) {
        return taskRepository.findByUserIdAndStatus(id, status);
    }

    public List<Task> getAllTasksUserByType(long id, Type type) {
        return taskRepository.findByUserIdAndType(id, type);
    }

    public void updateTask(long id, Task newTask) {
        taskRepository.findById(id).ifPresent(task -> {
            task.setTitle(newTask.getTitle());
            task.setStatus(newTask.getStatus());
            task.setType(newTask.getType());
            taskRepository.save(task);
        });
    }

    public void updateUser(long taskId, User user) {
        taskRepository.findById(taskId).ifPresent(task -> {
            task.setUser(user);
            taskRepository.save(task);
        });
    }

    public void deleteTaskById(long id){
        taskRepository.deleteById(id);
    }
}
