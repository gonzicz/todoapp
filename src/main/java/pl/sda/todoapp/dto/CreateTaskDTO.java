package pl.sda.todoapp.dto;

import lombok.Data;
import pl.sda.todoapp.model.Type;

@Data
public class CreateTaskDTO {
    private String title;
    private Type type;
    private int userId;
}
