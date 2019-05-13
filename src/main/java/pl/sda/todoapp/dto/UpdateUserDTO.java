package pl.sda.todoapp.dto;

import lombok.Data;

@Data
public class UpdateUserDTO extends CreateUserDTO {
    private long id;
}
