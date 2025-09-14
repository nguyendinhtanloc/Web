package murach.data;

import java.io.*;
import java.util.*;

import murach.business.User;

public class UserIO {
    public static void addRecord(User user, String filename)
    throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filename, true));
        out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName() + "|" +
            user.getHeardFrom() + "|" + user.getUpdates() + "|" + user.getContactVia());
        out.close();
    }   
    
    public static ArrayList<User> getUsers(String fileName) 
        throws IOException {
            ArrayList<User> users = new ArrayList<>();
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line = in.readLine();

            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String email = t.nextToken();
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                String heardFrom = t.nextToken();
                String updates = t.nextToken();
                String contactVia = t.nextToken();

                users.add(new User(email, firstName, lastName, heardFrom, updates, contactVia));
                line = in.readLine();
            }

            in.close();
            return users;
        }
}
