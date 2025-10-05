package vn.loc.controller;

import com.google.gson.Gson;
import vn.loc.model.Profile;

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
import java.time.LocalDate; // Thêm import này

@WebServlet("")
public class ProfileServlet extends HttpServlet {
    private Profile profileInfo;

    @Override
    public void init() throws ServletException {
        Gson gson = new Gson();
        // Dùng try-with-resources để đảm bảo stream được đóng đúng cách
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("profile.json")) {
            if (is == null) {
                throw new ServletException("Không tìm thấy file profile.json. Hãy đảm bảo file nằm trong thư mục 'src/main/resources'");
            }
            try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                this.profileInfo = gson.fromJson(reader, Profile.class);
            }
        } catch (IOException e) {
            throw new ServletException("Lỗi khi đọc file JSON", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tạo một bản sao của đối tượng profile để tránh thay đổi trạng thái gốc
        // Điều này quan trọng nếu servlet của bạn là singleton và được truy cập bởi nhiều người dùng
        Profile displayProfile = createDisplayProfile();

        // Xử lý thay thế ký tự xuống dòng bằng thẻ <br>
        String aboutMeContent = displayProfile.getAboutMe();
        if (aboutMeContent != null) {
            String formattedAboutMe = aboutMeContent.replace("\n", "<br/>");
            displayProfile.setAboutMe(formattedAboutMe); // Cập nhật lại nội dung đã format
        }

        // Lấy năm hiện tại để hiển thị ở footer
        int currentYear = LocalDate.now().getYear();
        request.setAttribute("currentYear", currentYear);

        request.setAttribute("profile", displayProfile);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    // Hàm phụ để tạo bản sao, giúp code an toàn hơn trong môi trường đa luồng
    private Profile createDisplayProfile() {
        Profile p = new Profile();
        p.setFullName(this.profileInfo.getFullName());
        p.setHeadline(this.profileInfo.getHeadline());
        p.setBio(this.profileInfo.getBio());
        p.setAboutMe(this.profileInfo.getAboutMe());
        p.setEmail(this.profileInfo.getEmail());
        p.setEducation(this.profileInfo.getEducation());
        p.setSkills(this.profileInfo.getSkills());
        p.setSocials(this.profileInfo.getSocials());
        p.setProjects(this.profileInfo.getProjects());
        return p;
    }
}