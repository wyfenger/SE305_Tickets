package com.tickets;




import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tickets.user.*;

public class controller extends HttpServlet
{
	public String FileInputStream(String path) throws IOException {
        File file=new File(path);
        //if(!file.exists()||file.isDirectory())
        //    throw new FileNotFoundException();
        FileInputStream fis=new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuffer sb=new StringBuffer();
        while((fis.read(buf))!=-1) {
            sb.append(new String(buf));    
            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
        }
        return sb.toString();
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    		userservice US = userservice.getistance();
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>controller</h1>");
            
            String uri = request.getRequestURI();
            if (uri.startsWith("/register")) {
            	response.getWriter().println("<h1>register</h1>");
            	String querystring = request.getQueryString();
            	String[] s = new String[2];
            	s = querystring.split("&");
            	int res = 0;
            	res = US.register(s[0], s[1]);
            	response.getWriter().println("<h1>" + "password = " + s[0] + "</h1>");
            	response.getWriter().println("<h1>" + "username = " + s[1] + "</h1>");
            	if (res == 0) {
            		response.getWriter().println("<h1>Username already exits</h1>");
            	} else {
            		response.getWriter().println("<h1>Registered success</h1>");
            	}
            } else if (uri.startsWith("/login")) {
            	String querystring = request.getQueryString();
            	String[] s = new String[2];
            	s = querystring.split("&");
            	int res = US.login(s[0], s[1]);
            	if (res == 0) {
            		response.getWriter().println("<h1>Username does not exist</h1>");
            	} else if (res == 1) {
            		response.getWriter().println("<h1>Username or Password is incorrect</h1>");
            	} else {
            		response.getWriter().println("<h1>Login success</h1>");
            	}
            } else if (uri.startsWith("/main")) {
            	String path = "src\\main\\resources\\";
            	String id = ""+1;
            	String ss = FileInputStream(path + id + ".json");
            	response.getWriter().println(ss);
            	for (int i = 1; i <= 1; i++) {
            		id = "" + i;
            		ss = FileInputStream(path + id + ".json");
            		response.getWriter().println(ss);
            	}
            } else if (uri.startsWith("/film")) {
            	String path = "src\\main\\resources\\";
            	String[] s = new String[2];
            	String querystring = request.getQueryString();
            	s = querystring.split("=");
            	int tmp = Integer.parseInt(s[1]);
            	String id = "" + tmp;
            	String ss = FileInputStream(path + id + ".json");
        		response.getWriter().println(ss);
            }
            
    }
}
