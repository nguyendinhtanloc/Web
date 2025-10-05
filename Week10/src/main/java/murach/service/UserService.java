package murach.service;

import murach.business.User;
import murach.data.UserRepository;
import java.util.List;

public class UserService {
    private final UserRepository repo = new UserRepository();

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserByEmail(String email) {
        return repo.findByEmail(email);
    }

    public boolean updateUser(User user) {
        repo.update(user);
        return true;
    }

    public boolean deleteUser(String email) {
        User user = repo.findByEmail(email);
        if (user != null) {
            repo.delete(user);
            return true;
        }
        return false;
    }

    public boolean addUser(User user) {
        if (!repo.emailExists(user.getEmail())) {
            repo.save(user);
            return true;
        }
        return false;
    }
}
