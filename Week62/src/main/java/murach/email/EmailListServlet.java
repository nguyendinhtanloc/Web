package murach.email;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.business.User;
import murach.data.UserIO;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        String url = "/index.jsp";

        // Lấy tham số 'action' từ request
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // Giá trị mặc định nếu không có action
        }

        // Xử lý action "join" (chỉ hiển thị trang index)
        if (action.equals("join")) {
            url = "/index.jsp";
        
        // Xử lý action "add" (thêm người dùng mới)
        } else if (action.equals("add")) {
            // 1. Lấy dữ liệu từ form
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String heardFrom = request.getParameter("heardFrom");
            String updates = request.getParameter("updates");
            String contactVia = request.getParameter("contactVia");

            // Xử lý trường hợp checkbox không được chọn (sẽ trả về null)
            if (updates == null) {
                updates = "No";
            }

            // 2. Tạo đối tượng User
            User user = new User(email, firstName, lastName, heardFrom, updates, contactVia);

            // 3. Validate dữ liệu
            String message;
            if (email == null || email.isEmpty() ||
                firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                heardFrom == null || heardFrom.isEmpty() ||
                contactVia == null || contactVia.isEmpty()) {

                // Nếu dữ liệu không hợp lệ: báo lỗi và quay lại trang index
                message = "Please fill out all required fields.";
                url = "/index.jsp";
            } else {
                // Nếu dữ liệu hợp lệ: chuyển đến trang cảm ơn và ghi file
                message = null; // Không có thông báo lỗi
                url = "/thanks.jsp";

                // 4. Chỉ ghi file KHI dữ liệu đã hợp lệ
                String path = getServletContext().getRealPath("/WEB-INF/EmailList.txt");
                System.out.println("!!! SERVER ATTEMPTING TO WRITE TO: " + path); 
                UserIO.addRecord(user, path);
            }

            // 5. Set attributes để JSP có thể hiển thị
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }

        // Đặt thuộc tính năm hiện tại cho footer
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);

        // 6. Forward tới URL đã được xác định
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển tiếp tất cả các request GET đến doPost để xử lý
        doPost(request, response);
    }
}
