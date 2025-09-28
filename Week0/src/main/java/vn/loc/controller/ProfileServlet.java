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

@WebServlet("")
public class ProfileServlet extends HttpServlet {
    private Profile profileInfo;

    @Override
    public void init() throws ServletException {
        Gson gson = new Gson();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("profile.json");
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            if (is == null) {
                throw new ServletException("Không tìm thấy file profile.json. Hãy đảm bảo file nằm trong thư mục 'src/main/resources'");
            }
            this.profileInfo = gson.fromJson(reader, Profile.class);

        } catch (IOException e) {
            throw new ServletException("Lỗi khi đọc file JSON", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("profile", this.profileInfo);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}