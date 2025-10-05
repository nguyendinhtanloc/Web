package murach.admin;

import murach.business.User;
import murach.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "display_users";

        HttpSession session = request.getSession();
        String url = "/users.jsp";

        switch (action) {
            case "display_users":
                List<User> users = userService.getAllUsers();
                request.setAttribute("users", users);
                break;

            case "display_user":
                String email = request.getParameter("email");
                User user = userService.getUserByEmail(email);
                session.setAttribute("user", user);
                url = "/user.jsp";
                break;

            case "update_user":
                User userToUpdate = (User) session.getAttribute("user");
                userToUpdate.setFirstName(request.getParameter("firstName"));
                userToUpdate.setLastName(request.getParameter("lastName"));
                userService.updateUser(userToUpdate);
                request.setAttribute("users", userService.getAllUsers());
                break;

            case "delete_user":
                userService.deleteUser(request.getParameter("email"));
                request.setAttribute("users", userService.getAllUsers());
                break;

            case "add_user":
                User newUser = new User(
                    request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("email")
                );
                boolean added = userService.addUser(newUser);
                request.setAttribute("users", userService.getAllUsers());
                request.setAttribute("message", added ? "User added." : "Email already exists.");
                break;
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
