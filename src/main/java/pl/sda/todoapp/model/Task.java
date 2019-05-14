package pl.sda.todoapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private LocalDate addDate;
    private Type type;
    private Status status;

    @ManyToOne
    private User user;
}
