package Emp;

import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

@WebServlet("/Empreg")
public class Empregis extends HttpServlet {  

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchain_auditor","root","root");
Statement st=con.createStatement();

String n=request.getParameter("name");  
String e=request.getParameter("email");  
String p=request.getParameter("pan");  
String pa=request.getParameter("pas"); 

String strQuery = "SELECT EMAIL, PANID FROM empreg where PANID='"+p+"'";
ResultSet rs = st.executeQuery(strQuery);
if(rs.next())
{
	out.println("<html><body><script>alert('PAN ID already exists !');</script></body></html>");
	RequestDispatcher rd=request.getRequestDispatcher("registration.html");  
	rd.include(request,response);  
}
else
{
	
	int i=st.executeUpdate("insert into empreg(NAME,EMAIL,PASSWORD,PANID)values('"+n+"','"+e+"','"+pa+"','"+p+"')");
	RequestDispatcher rd=request.getRequestDispatcher("signup.html");  
	rd.forward(request,response);  
	out.print("Registered Successfully");
}
}
catch (Exception e){
e.printStackTrace();
}

          
out.close();  
}  
  
}  