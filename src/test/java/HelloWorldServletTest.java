import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.junit.*;
import org.mockito.*;

public class HelloWorldServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private ServletContext context;

    private StringWriter stringWriter;
    private HelloWorldServlet servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new HelloWorldServlet();
        stringWriter = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));
        when(request.getServletContext()).thenReturn(context);
        when(context.getContextPath()).thenReturn("");
    }

    @Test
    public void testDoGetWithNullAbcParam() throws Exception {
        when(request.getParameter("abc")).thenReturn(null);
        servlet.doGet(request, response);
        verify(request, atLeastOnce()).getParameter("abc");
        assertTrue(stringWriter.toString().contains("<h1>Hello World</h1>"));
        verify(response, atLeastOnce()).setContentType("text/html");
    }

    @Test
    public void testDoGetWithNonNullAbcParam() throws Exception {
        when(request.getParameter("abc")).thenReturn("test");
        servlet.doGet(request, response);
        verify(request, atLeastOnce()).getParameter("abc");
        //System.out.print(request.getParameter("abcParam"));
        verifyNoInteractions(response);
    }
}