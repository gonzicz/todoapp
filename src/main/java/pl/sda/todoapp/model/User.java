package pl.sda.todoapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String mail;

    // relacja w dwie strony oraz kaskada ( jeśli usuniemy użytkownika to odrazu usuwa
    // nam taski, do których dany użytkownik był przypisany )
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Task> tasks;
}
