import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.junit.*;
import org.mockito.*;

public class HelloWorldFilterTest {
    @Test
    public void testDoFilter() throws ServletException, IOException {
        // przygotowanie danych wejściowych
        String abcValue = "test";
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("abc")).thenReturn(abcValue);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // uruchomienie testowanej metody
        HelloWorldFilter filter = new HelloWorldFilter();
        filter.doFilter(request, response, chain);

        // asercje
        verify(response).setContentType("text/html");
        String output = stringWriter.toString();
        assertTrue(output.contains("<p>" + abcValue + "</p>"));
        assertTrue(output.contains("<h1>Hello World</h1>"));
        assertTrue(output.contains("<p>" + abcValue + "</p>"));
    }
}