// Khai báo package, giúp tổ chức và quản lý các lớp trong dự án.
package murach.download;

// Import các thư viện cần thiết cho việc xử lý input/output và các thành phần của Servlet.
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
// Import lớp User từ package business để có thể sử dụng.
import murach.business.User;

/**
 * DownloadServlet hoạt động như một Controller để điều hướng các yêu cầu (requests)
 * liên quan đến việc đăng ký và tải xuống của người dùng.
 */
public class DownloadServlet extends HttpServlet {

    /**
     * Xử lý các request HTTP GET.
     * Trong trường hợp này, phương thức doGet chỉ đơn giản gọi doPost để xử lý.
     * Điều này giúp thống nhất logic xử lý cho cả hai loại request GET và POST.
     * @param request Đối tượng chứa thông tin request từ client.
     * @param response Đối tượng để gửi response về cho client.
     * @throws ServletException Nếu có lỗi liên quan đến servlet.
     * @throws IOException Nếu có lỗi I/O.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Xử lý các request HTTP POST. Đây là nơi chứa logic chính của servlet.
     * @param request Đối tượng chứa thông tin request từ client.
     * @param response Đối tượng để gửi response về cho client.
     * @throws ServletException Nếu có lỗi liên quan đến servlet.
     * @throws IOException Nếu có lỗi I/O.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Khởi tạo biến url với giá trị mặc định là trang chủ.
        String url = "/index.jsp";

        // Lấy giá trị của tham số 'action' từ request.
        // Tham số này quyết định hành động mà servlet sẽ thực hiện.
        String action = request.getParameter("action");
        if (action == null) {
            // Nếu không có 'action' nào được gửi, gán hành động mặc định là "join".
            action = "join";
        }

        // --- Bắt đầu phân nhánh logic dựa trên giá trị của 'action' ---

        // Nếu hành động là "join", chuyển người dùng đến trang đăng ký.
        if (action.equals("join")) {
            url = "/register.jsp";
        }
        // Nếu hành động là "registerUser", xử lý dữ liệu từ form đăng ký.
        else if (action.equals("registerUser")) {
            // Lấy tất cả thông tin mà người dùng đã nhập từ form.
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String heardFrom = request.getParameter("heardFrom");
            String updates = request.getParameter("updates");
            String contactVia = request.getParameter("contactVia");

            // Tạo một đối tượng User rỗng bằng constructor mặc định.
            User user = new User();
            // Sử dụng các phương thức setter để gán giá trị cho từng thuộc tính của đối tượng.
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setHeardFrom(heardFrom);
            user.setUpdates(updates);
            user.setContactVia(contactVia);

            // Đặt đối tượng user vào request scope để trang JSP tiếp theo có thể truy cập.
            request.setAttribute("user", user);

            // Tạo một cookie để lưu lại tên của người dùng trên trình duyệt của họ.
            Cookie c = new Cookie("firstNameCookie", user.getFirstName());
            // Thiết lập "tuổi thọ" của cookie là 2 năm (tính bằng giây).
            c.setMaxAge(60 * 60 * 24 * 365 * 2);
            // Thiết lập đường dẫn cho cookie, "/" nghĩa là nó có hiệu lực trên toàn bộ ứng dụng.
            c.setPath("/");
            // Gửi cookie về trình duyệt của client để lưu trữ.
            response.addCookie(c);

            // Sau khi đăng ký thành công, đặt URL để chuyển người dùng về trang chủ.
            url = "/index.jsp";
        }
        // Nếu hành động là "checkUser", kiểm tra cookie để xác thực người dùng.
        else if (action.equals("checkUser")) {
            // Lấy tất cả các cookie từ request của trình duyệt.
            Cookie[] cookies = request.getCookies();
            // Chuẩn bị một biến để lưu giá trị tên từ cookie.
            String firstName = "";
            // Kiểm tra xem mảng cookie có tồn tại không (tránh lỗi NullPointerException).
            if (cookies != null) {
                // Duyệt qua từng cookie trong mảng.
                for (Cookie c : cookies) {
                    // Nếu tìm thấy cookie có tên là "firstNameCookie"...
                    if (c.getName().equals("firstNameCookie")) {
                        // ...lấy giá trị của nó (tên người dùng) và thoát vòng lặp.
                        firstName = c.getValue();
                        break;
                    }
                }
            }
            
            // Dựa vào việc có tìm thấy tên trong cookie hay không để quyết định URL tiếp theo.
            if (firstName.equals("")) {
                // Nếu không tìm thấy cookie, người dùng phải đăng ký.
                url = "/register.jsp";
            } else {
                // Nếu tìm thấy, người dùng được phép truy cập trang download.
                url = "/download.jsp";
            }
        }

        // Sử dụng RequestDispatcher để chuyển tiếp (forward) request và response đến trang JSP đã được xác định trong biến 'url'.
        // Quá trình này diễn ra trên server, URL trên trình duyệt của người dùng không thay đổi.
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}