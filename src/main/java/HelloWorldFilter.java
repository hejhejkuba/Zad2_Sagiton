import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/hello.world")
public class HelloWorldFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String abcParam = request.getParameter("abc");

        if (abcParam != null) {
            response.setContentType("text/html");
            response.getWriter().println("<p>" + abcParam + "</p>");
            response.getWriter().println("<h1>" + "Hello World" + "</h1>");

        }

        chain.doFilter(request, response);

        if (abcParam != null) {
            response.getWriter().println("<p>" + abcParam + "</p>");
        }
    }

    @Override
    public void destroy() {
    }
}
