package murach.download;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productCode = request.getParameter("productCode");
        String url;

        switch (productCode) {
            case "pf01":
                url = "/pf01_download.jsp";
                break;
            case "register":
                url = "/register.jsp";
                break;
            default:
                url = "/index.jsp";
                break;
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
