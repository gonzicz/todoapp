package pl.sda.todoapp.dto;

import org.springframework.stereotype.Component;
import pl.sda.todoapp.model.Status;
import pl.sda.todoapp.model.Task;
import pl.sda.todoapp.model.User;

import java.time.LocalDate;

@Component
public class TaskMapper {
    public Task model(CreateTaskDTO taskDTO) {
        Task task = new Task();
        User user = new User();
        user.setId(taskDTO.getUserId());
        task.setTitle(taskDTO.getTitle());
        task.setType(taskDTO.getType());
        task.setStatus(Status.NEW);
        task.setAddDate(LocalDate.now());
        task.setUser(user);
        return task;
    }

    public TaskDTO toDto (Task task){
        TaskDTO taskDto = new TaskDTO();
        taskDto.setTitle(task.getTitle());
        taskDto.setStatus(task.getStatus());
        taskDto.setType(task.getType());
        taskDto.setAddDate(task.getAddDate());
        taskDto.setUserName(task.getUser().getName() + " " + task.getUser().getSurname());
        taskDto.setId(task.getId());
        taskDto.setUserId(task.getUser().getId());
        return taskDto;
    }

    public Task model(UpdateTaskDTO updateTaskDTO) {
        Task task = new Task();
        task.setTitle(updateTaskDTO.getTitle());
        task.setStatus(updateTaskDTO.getStatus());
        task.setType(updateTaskDTO.getType());
        return task;
    }
}
