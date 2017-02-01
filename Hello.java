package ubiserv.simple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Hello extends HttpServlet
{
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException
    {
        httpServletResponse.setContentType("text/plain");
        PrintWriter out = httpServletResponse.getWriter();
        out.println("Hello CS2001 from Steve");
	String x = httpServletRequest.getQueryString();
	out.println(x);
        out.close();
    }
}
