package murach.service;

import murach.business.User;
import murach.data.UserIO;

public class UserService {

    public static boolean registerUser(User user, String path) {
        return UserIO.add(user, path);
    }

    public static User findUserByEmail(String email, String path) {
        return UserIO.getUser(email, path);
    }
}
