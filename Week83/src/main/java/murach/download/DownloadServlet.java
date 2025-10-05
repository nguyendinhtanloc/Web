package murach.download;

import murach.business.Product;
import murach.data.ProductIO;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        String productCode = request.getParameter("productCode");
        if (productCode == null || productCode.isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/products.txt");
        Product product = ProductIO.getProduct(productCode, path);

        if (product == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        request.setAttribute("product", product);

        String url = "/" + productCode + "_download.jsp";
        sc.getRequestDispatcher(url).forward(request, response);
    }
}
