package vn.loc.controller;

import com.google.gson.Gson;
import vn.loc.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@WebServlet("") // Map servlet này với URL gốc của web
public class ProfileServlet extends HttpServlet {
    private Student studentInfo;

    @Override
    public void init() throws ServletException {
        // Đọc file JSON chỉ một lần khi servlet khởi tạo để tối ưu hiệu suất
        Gson gson = new Gson();
        try (InputStream is = getServletContext().getResourceAsStream("/WEB-INF/classes/student.json");
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            
            if (is == null) {
                throw new ServletException("Không tìm thấy file student.json. Hãy đảm bảo file nằm trong src/main/resources");
            }
            
            this.studentInfo = gson.fromJson(reader, Student.class);

        } catch (IOException e) {
            throw new ServletException("Lỗi khi đọc file JSON", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Đặt đối tượng student vào request để JSP có thể truy cập
        request.setAttribute("student", this.studentInfo);
        
        // Chuyển tiếp request đến file index.jsp để hiển thị
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}