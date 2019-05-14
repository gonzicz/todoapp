package pl.sda.todoapp.dto;

import lombok.Data;
import pl.sda.todoapp.model.Status;
import pl.sda.todoapp.model.Type;

@Data
public class UpdateTaskDTO {
    private String title;
    private Type type;
    private Status status;
}
