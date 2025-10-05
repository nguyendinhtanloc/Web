package murach.data;

import java.io.*;
import murach.business.User;

public class UserIO {

    public static void add(User user, String filename) throws IOException {
        File file = new File(filename);
        try (PrintWriter out = new PrintWriter(new FileWriter(file, true))) {
            out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName());
        }
    }
}
