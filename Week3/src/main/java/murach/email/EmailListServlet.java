package murach.email;

import java.io.*;
import java.util.Calendar;
import javax.servlet.*;
import javax.servlet.http.*;
import murach.business.User;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);

        String url = "/index.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("add")) {
            // Lấy TẤT CẢ thông tin từ form
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String hear = request.getParameter("hear");
            String contact = request.getParameter("contact");
            boolean offers = request.getParameter("offers") != null;
            boolean emailOK = request.getParameter("emailOK") != null;

            // Tạo và cập nhật đầy đủ thông tin cho user
            User user = new User(firstName, lastName, email, dob);
            user.setHear(hear);
            user.setOffers(offers);
            user.setEmailOK(emailOK);
            user.setContact(contact);

            request.setAttribute("user", user);
            url = "/thanks.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);
        
        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}