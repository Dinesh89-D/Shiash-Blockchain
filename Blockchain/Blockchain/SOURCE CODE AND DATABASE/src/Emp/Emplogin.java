package Emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Emplogin")
public class Emplogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("email");  
	    String p=request.getParameter("pass");  
	          
	    if(EmpDAO.validate(n, p))
	    {  
	    	HttpSession session=request.getSession();  
	    	session.setAttribute("email", n);
	        RequestDispatcher rd=request.getRequestDispatcher("Emphome.jsp");  
	        rd.forward(request,response);  
	        out.print("Successfully Logged In");
	    }  
	    else if(EmpDAO.validate2(n, p))
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("keygen.jsp");  
	        rd.forward(request,response);  
	    }
	    else if(n.equalsIgnoreCase("Admin") && p.equalsIgnoreCase("Admin")) 
	    {

	        String S = "yuvi";
	        HttpSession session = request.getSession();  
	    	session.setAttribute("ses", S);
	    	
	    	RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");  
	        rd.forward(request,response); 
	    }
	    else if(n.equalsIgnoreCase("Auditor") && p.equalsIgnoreCase("Auditor")) 
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("Auditorhome.jsp");  
	        rd.forward(request,response); 
	    }
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("signup.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	}

}
