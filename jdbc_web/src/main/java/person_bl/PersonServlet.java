package person_bl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.print("Hello from servlet");
//        writer.flush();
        req.setAttribute("attr_name", "Java EE");
        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}
