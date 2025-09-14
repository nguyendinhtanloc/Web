package murach.email;

import java.io.*; // thư viện input/output
import java.util.Calendar;
import java.util.GregorianCalendar; // dùng để lấy thời gian hiện tại

import javax.servlet.*; // nền tảng xây dựng các trang web bằng java
import javax.servlet.http.*; // là một phần của servlet xử lý các giao thức http

import murach.business.User;

public class Email extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

        String action = request.getParameter("action"); // lấy giá trị tham số từ yêu cầu
        if (action == null) {   // nếu không có tham số nào được gửi, ví dụ người dùng đăng nhập lần đầu
            action = "join";    // hành động mặc định là join
            url = "/index.jsp";     // di chuyển đến trang chủ, nơi có form đăng ký
        }

        // nếu hành động là join thì sẽ truy cập vào trang chủ
        if (action.equals("join")) {
            url = "/index.jsp";
        } else if (action.equals("add")) { // nếu hành động là thêm 
            // trước tiên sẽ lấy thông tin của người dùng gửi
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // tạo một user từ những thông tin được gửi về
            User user = new User(firstName, lastName, email);

            String message;     
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill all";
                url = "/index.jsp"; //  Dữ liệu trống thì sẽ ở lại trang chủ
            } else {
                message = null;
                url = "/thanks.jsp";    // nếu không trống thì chuyển đến trang thanks.jsp
            }
            
            // gửi dữ liệu lại cho trang jsp
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }

        // tạo mục đích để lấy thời gian hiện tại, hay thường sử dụng ở cuối trang, ví dụ như nguyendinhtanloc 2025
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR); 
        request.setAttribute("currentYear", currentYear);

        // chuyển hướng đến với url
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    // cả 2 Get và Post đều có một mục đích chung là tìm kiếm nên chỉ cần viết code một cái, cái còn lại thì gọi
    // get là giống như tìm kiếm trên Google, ai cũng có thể thấy được
    // post giống như đăng nhập, khi đăng nhập thì tài khoản mật khẩu được gửi đi sẽ được đóng kín
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
        }   
}
