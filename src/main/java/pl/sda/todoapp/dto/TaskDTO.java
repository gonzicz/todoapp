package pl.sda.todoapp.dto;

import lombok.Data;
import pl.sda.todoapp.model.Status;
import pl.sda.todoapp.model.Type;

import java.time.LocalDate;

@Data
public class TaskDTO {
    private long id;
    private String title;
    private LocalDate addDate;
    private Type type;
    private Status status;
    private long userId;
    private String userName;
}
