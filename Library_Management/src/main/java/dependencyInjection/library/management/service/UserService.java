package dependencyInjection.library.management.service;

import dependencyInjection.library.management.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
}
