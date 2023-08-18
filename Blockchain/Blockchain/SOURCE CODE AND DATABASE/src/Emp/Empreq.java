package Emp;

import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import java.text.SimpleDateFormat;

@WebServlet("/Empreq")
public class Empreq extends HttpServlet {  

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

	// For Date

java.util.Date now = new java.util.Date();
String date=now.toString();
String DATE_FORMAT = "dd-MM-yyyy";
SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
String strDateNew = sdf.format(now) ;
String date1= strDateNew;

response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("uname");  
String e=request.getParameter("email");  
String d=request.getParameter("desc"); 
String p=request.getParameter("pan");  

          
try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/blockchain_auditor","root","root"); 
  
	String description = "Requesting_Key";
	Statement st= con.createStatement();
	ResultSet rs = st.executeQuery("select * from keyrequests where PANID='"+p+"' and DESCR='"+description+"'");
	
	if(rs.next()) 
	{
		out.println("<html><body><script>alert('Key Already Requested');</script></body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("Emphome.jsp");  
		rd.forward(request, response);
	}
	else 
	{
		PreparedStatement ps=con.prepareStatement("insert into keyrequests(NAME,EMAIL,DESCR,PANID,DATE) values(?,?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,e);  
		ps.setString(3,d); 
		ps.setString(4,p);  
		ps.setString(5,date1);  
          
		int i=ps.executeUpdate();  
		if(i>0)
		{  
   
		RequestDispatcher rd = request.getRequestDispatcher("response.jsp");  
		rd.forward(request, response);
		out.print("Your request sent successfully"); 
		} 
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Emphome.jsp");  
			rd.include(request, response);
			out.print("Incorrect credentials"); 
	    }
	}
}
catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  