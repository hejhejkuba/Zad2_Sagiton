import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.junit.*;
import org.mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;


public class FooWorldServletTest {
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private ServletContext context;


    private StringWriter stringWriter;
    private FooWorldServlet servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new FooWorldServlet();
        stringWriter = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));
        when(request.getServletContext()).thenReturn(context);
        when(context.getContextPath()).thenReturn("");
    }
    @Test(expected = ServletException.class)
    public void TestFooWorldException() throws Exception{
        servlet.doGet(request, response);
    };

}