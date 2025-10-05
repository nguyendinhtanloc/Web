package murach.register;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import murach.business.User;
import murach.data.UserIO;

public class RegisterUserServlet extends HttpServlet {

    private String filePath;

    @Override
    public void init() {
        // Đường dẫn file lưu danh sách người dùng
        filePath = getServletContext().getRealPath("/WEB-INF/EmailList.txt");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy dữ liệu từ form
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        // Tạo đối tượng User
        User user = new User(firstName, lastName, email);

        // Ghi vào file
        UserIO.add(user, filePath);

        // Lưu vào session (tuỳ chọn)
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // Chuyển hướng đến trang cảm ơn
        String url = "/thanks.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
