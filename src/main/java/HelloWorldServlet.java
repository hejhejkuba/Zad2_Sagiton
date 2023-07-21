import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello.world")
public class HelloWorldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String abcParam = request.getParameter("abc");
        String message = "Hello World";

        if (abcParam == null) {
            System.out.println(abcParam);
            // wypisanie "Hello World"
            response.setContentType("text/html");
            response.getWriter().println("<h1>" + message + "</h1>");
        }

    }
}

