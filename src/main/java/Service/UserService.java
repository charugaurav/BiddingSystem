package Service;

import models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long userId);
    User saveUser(User user);
}
