package com.tickets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.tickets.user.*;

import com.tickets.user.userservice;


public class controller extends HttpServlet
{
	//public userservice US;
	//private static volatile controller instance;  
    /*public static controller getistance() { 
        if (instance == null) {
            synchronized (controller.class) {
                if (instance == null) {
                    instance = new controller();
                }
            }
        }
        return instance;   
    }*/
	//userservice usp = userservice.getistance();
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
            }
            /*
            response.getWriter().println("<h1>Hello Servlet</h1>");
            response.getWriter().println("<h1>"+"url=" + request.getRequestURL()+"</h1>");
            
            response.getWriter().println("uri=" + request.getRequestURI());
            
            response.getWriter().println("querystring=" + request.getQueryString());
            
            response.getWriter().println("RemoteAddr=" + request.getRemoteAddr() + '\n');
            
            response.getWriter().println("RemoteHost=" + request.getRemoteHost());
            
            response.getWriter().println("Method=" + request.getMethod());
            */
    }
}
