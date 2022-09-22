package spring.mvc.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user ="springstudent";
		String pass ="springstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-movie-review?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	    String driver = "com.mysql.cj.jdbc.Driver";
	    
	    // get connection
	    try {
	    	
	    	PrintWriter out = response.getWriter();
	    	
	    	out.println("Connectiong to data base "+jdbcUrl);
	    	
	    	Class.forName(driver);
	    	
	    	Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
	    	
	    	out.println("\nSuccess");
	    	
	    	myConn.close();
	    	
	    }catch(Exception exc){
	    	exc.printStackTrace();
	    	throw new ServletException(exc);
	    }
	
	}

	
}
