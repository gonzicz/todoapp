package pl.sda.todoapp.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    protected String name;
    protected String surname;
    protected String mail;
}
