package com.sree.EmbeddedServer;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("hello servlet...in service.");
		PrintWriter out  = res.getWriter();
		
		out.println("<html><h1> hi holly servlet embedded server...</h1></html>");
	}
}
