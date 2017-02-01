package ubiserv.simple;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHttpContext;

public class JettyStart
{
    public static void main(String[] args) throws Exception
    {
        //A server running at http://localhost:8085 is created
        Server server = new Server();
        server.addListener(":8085");

        ServletHttpContext context = (ServletHttpContext) server.getContext("/");
        context.addServlet("/Lab4", "ubiserv.simple.Lab4Servlet");
        context.addServlet("/Hello", "ubiserv.simple.Hello");
        context.addServlet("/Shares", "ubiserv.simple.Shares");
        context.addServlet("/Test", "ubiserv.simple.Test");
        context.addServlet("/Execute","ubiserv.simple.Execute");

        server.start();
    }
}
