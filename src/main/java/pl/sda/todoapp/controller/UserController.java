package pl.sda.todoapp.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.todoapp.dto.CreateUserDTO;
import pl.sda.todoapp.dto.UpdateUserDTO;
import pl.sda.todoapp.dto.UserDTO;
import pl.sda.todoapp.dto.UserMapper;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    Iterable<UserDTO> getAllUsers() {
        return userMapper.dto(userService.getAllUsers());
    }

    @PostMapping
    UserDTO addUser(@RequestBody CreateUserDTO createUserDTO) {
        return userMapper.dto(userService.addUser(userMapper.model(createUserDTO)));
    }

    @GetMapping("/{id}")
    Optional<UserDTO> findUserById(@PathVariable long id) {
        return userService.getUserById(id).map((user)->userMapper.dto(user));
    }

    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    UserDTO updateUser(@PathVariable long id, @RequestBody UpdateUserDTO updateUserDTO) {
        updateUserDTO.setId(id);
        return userMapper.dto(userService.updateUser(userMapper.model(updateUserDTO)));
    }
}
