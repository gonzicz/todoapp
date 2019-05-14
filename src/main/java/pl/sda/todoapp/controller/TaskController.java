package pl.sda.todoapp.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.todoapp.dto.CreateTaskDTO;
import pl.sda.todoapp.dto.TaskDTO;
import pl.sda.todoapp.dto.TaskMapper;
import pl.sda.todoapp.model.Status;
import pl.sda.todoapp.model.Task;
import pl.sda.todoapp.model.Type;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskController(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    TaskDTO addTask(@RequestBody CreateTaskDTO taskDTO) {
        return taskMapper.toDto(taskRepository.save(taskMapper.model(taskDTO)));
    }

    @GetMapping("/{id}")
    Optional<TaskDTO> findTaskById(@PathVariable long id){
        return taskRepository.findById(id).map(task->taskMapper.toDto(task));
    }

    @GetMapping(params = "user")
    Stream<TaskDTO> getAllTasksUser(@RequestParam ("user") long id){
        return taskRepository.findByUserId(id).stream().map(task->taskMapper.toDto(task));
    }

    @GetMapping(params = {"user", "status"})
    Stream<TaskDTO> getAllTasksUserByStatus(@RequestParam("user") long id,@RequestParam("status") Status status){
        return taskRepository.findByUserIdAndStatus(id, status).stream().map(taskMapper::toDto);
    }

    @GetMapping(params = {"user", "type"})
    Stream<TaskDTO> getAllTasksUserByType(@RequestParam("user") long id,@RequestParam("type") Type type){
        return taskRepository.findByUserIdAndType(id, type).stream().map(taskMapper::toDto);
    }

    @PutMapping("/{id}")
    

}
