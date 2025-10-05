package murach.sql;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/sqlGateway")
public class SqlGatewayServlet extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("LessonAppPU");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sqlStatement = request.getParameter("sqlStatement");
        String sqlResult;

        if (sqlStatement == null || sqlStatement.trim().isEmpty()) {
            sqlResult = "<p>Vui lòng nhập lệnh SQL.</p>";
        } else {
            sqlStatement = sqlStatement.trim();
            String lower = sqlStatement.toLowerCase();

            if (!(lower.startsWith("select") || lower.startsWith("insert") ||
                  lower.startsWith("update") || lower.startsWith("delete"))) {
                sqlResult = "<p>Lệnh không được phép. Chỉ cho phép SELECT, INSERT, UPDATE, DELETE.</p>";
            } else {
                EntityManager em = emf.createEntityManager();
                try {
                    if (lower.startsWith("select")) {
                        Query query = em.createNativeQuery(sqlStatement);
                        List<?> results = query.getResultList();
                        sqlResult = formatResultsAsHtml(results);
                    } else {
                        em.getTransaction().begin();
                        Query query = em.createNativeQuery(sqlStatement);
                        int affected = query.executeUpdate();
                        em.getTransaction().commit();
                        sqlResult = "<p>Lệnh thực thi thành công.<br>" + affected + " dòng bị ảnh hưởng.</p>";
                    }
                } catch (Exception e) {
                    sqlResult = "<p>Lỗi khi thực thi SQL: " + e.getMessage() + "</p>";
                } finally {
                    em.close();
                }
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlStatement", sqlStatement);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    private String formatResultsAsHtml(List<?> results) {
        StringBuilder html = new StringBuilder("<table class='table table-bordered'>");
        for (Object row : results) {
            html.append("<tr>");
            if (row instanceof Object[]) {
                for (Object col : (Object[]) row) {
                    html.append("<td>").append(col).append("</td>");
                }
            } else {
                html.append("<td>").append(row).append("</td>");
            }
            html.append("</tr>");
        }
        html.append("</table>");
        return html.toString();
    }
}
