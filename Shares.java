package ubiserv.simple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.*;
import java.io.*;

public class Shares extends HttpServlet
{
  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException
  {
  // URL of the BT Share price
  URL yahoo = new URL("http://uk.finance.yahoo.com/q?d=t&p=&q=q&s=BT&m=L");
  URLConnection yc = yahoo.openConnection();
  BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
  String inputLine;
  int posPrice=0;
  // Loop until an identifcation string is found
  while ((inputLine = in.readLine()) != null){
     // Find the content you require and generate UI
     posPrice=inputLine.indexOf("big");
     if ( posPrice>0 ) break;
  }
  in.close();

  if ( posPrice>0){
	httpServletResponse.setContentType("text/plain");
    PrintWriter out = httpServletResponse.getWriter();
    out.println("<Title>Share Price App</Title>");
    out.println("<Prompt>BT Share price is "+inputLine.substring(posPrice+7, posPrice+14)+"</Prompt>");
    out.println("<Text>Generated from Yahoo data</Text>");
    out.println("</CiscoIPPhoneText>");
  }
  else System.out.println("ERROR: Cannot find the share");
  }
}