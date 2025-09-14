package murach.controller;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.*;
import javax.servlet.http.*;

import murach.business.User;

public class SurveyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

        String action = request.getParameter("action");
        if (action == null) {
            url = "/index.jsp";
            action = "join";
        }

        if (action.equals("join")) {
            url = "/index.jsp";
        } else if (action.equals("add")) {
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String heardFrom = request.getParameter("heardFrom");
            String updates = request.getParameter("updates");
            String contactVia = request.getParameter("contactVia");

            User user = new User(email, firstName, lastName, heardFrom, updates, contactVia);

            String message;
            if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                    heardFrom.isEmpty() || updates.isEmpty() || contactVia.isEmpty()) {
                message = "Please fill all";
                url = "/index.jsp";
            } else {
                message = null;
                url = "/thanks.jsp";
            }

            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }

        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    }
}
