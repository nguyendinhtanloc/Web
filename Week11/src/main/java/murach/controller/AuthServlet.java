package murach.controller;

import murach.model.Account;
import murach.service.AuthService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class AuthServlet extends HttpServlet {
    private final AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Account account = authService.login(email, password);

        if (account != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInAccount", account);
            response.sendRedirect("profile.jsp");
        } else {
            request.setAttribute("errorMessage", "Email hoặc mật khẩu không đúng.");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.jsp");
    }
}
