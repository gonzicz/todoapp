package pl.sda.todoapp.dto;

import org.springframework.stereotype.Component;
import pl.sda.todoapp.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User model(CreateUserDTO createUserDTO) {
        return createNewUser(createUserDTO);
    }

    public User model(UpdateUserDTO updateUserDTO) {
        User newUser = createNewUser(updateUserDTO);
        newUser.setId(updateUserDTO.getId());
        return newUser;
    }

    private User createNewUser(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setName(createUserDTO.getName());
        user.setSurname(createUserDTO.getSurname());
        user.setMail(createUserDTO.getMail());
        return user;
    }
    public UserDTO dto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setMail(user.getMail());
        return userDTO;
    }
    public Iterable<UserDTO> dto (Collection<User> users){
        return users.stream().map(this::dto).collect(Collectors.toList());
    }
}
