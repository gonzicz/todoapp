package pl.sda.todoapp.service;

import org.springframework.stereotype.Service;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.repository.TaskRepository;
import pl.sda.todoapp.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private TaskRepository taskRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    /**
     *  @Transactional, taskRepository.deleteByUserId(id)  oraz taskRepository.deleteById() [ w klasie TaskRepository ]
     *  możemy zakomentować ponieważ używamy kaskad
     */
    // @Transactional
    public void deleteUserById(long id) {
        // taskRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
