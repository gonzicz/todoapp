package pl.sda.todoapp.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.todoapp.dto.CreateTaskDTO;
import pl.sda.todoapp.dto.TaskDTO;
import pl.sda.todoapp.dto.TaskMapper;
import pl.sda.todoapp.dto.UpdateTaskDTO;
import pl.sda.todoapp.model.Status;
import pl.sda.todoapp.model.Type;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.repository.TaskRepository;
import pl.sda.todoapp.service.TaskService;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private TaskMapper taskMapper;
    private TaskService taskService;

    public TaskController(TaskMapper taskMapper, TaskService taskService) {
        this.taskMapper = taskMapper;
        this.taskService = taskService;
    }

    @PostMapping
    TaskDTO addTask(@RequestBody CreateTaskDTO taskDTO) {
        return taskMapper.toDto(taskService.addTask(taskMapper.model(taskDTO)));
    }

    @GetMapping
    Stream<TaskDTO> getAllTasks() {
        return taskService.getAllTasks().stream().map(taskMapper::toDto);
    }

    @GetMapping("/{id}")
    Optional<TaskDTO> findTaskById(@PathVariable long id) {
        return taskService.findTaskById(id).map(task -> taskMapper.toDto(task));
    }

    @GetMapping(params = "user")
    Stream<TaskDTO> getAllTasksUser(@RequestParam("user") long id) {
        return taskService.getAllTasksUser(id).stream().map(task -> taskMapper.toDto(task));
    }

    @GetMapping(params = {"user", "status"})
    Stream<TaskDTO> getAllTasksUserByStatus(@RequestParam("user") long id, @RequestParam("status") Status status) {
        return taskService.getAllTasksUserByStatus(id, status).stream().map(taskMapper::toDto);
    }

    @GetMapping(params = {"user", "type"})
    Stream<TaskDTO> getAllTasksUserByType(@RequestParam("user") long id, @RequestParam("type") Type type) {
        return taskService.getAllTasksUserByType(id, type).stream().map(taskMapper::toDto);
    }

    @PutMapping(value = "/{id}")
    void updateTask(@PathVariable Long id, @RequestBody UpdateTaskDTO updateTaskDTO) {
        taskService.updateTask(id,taskMapper.model(updateTaskDTO));
    }

    @PutMapping(value = "/{taskId}/user")
    public void updateUser(@PathVariable long taskId, @RequestBody User newUser) {
        taskService.updateUser(taskId, newUser);
    }

    @DeleteMapping("/{id}")
    void deleteTaskById(@PathVariable long id){
        taskService.deleteTaskById(id);
    }

}
