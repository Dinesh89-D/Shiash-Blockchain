package Emp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;

@WebServlet("/uploaddetails2")
public class uploaddetails2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		HttpSession ses=request.getSession();
		String message=null;
		
		String pkey=request.getParameter("pkey");
		String fname=request.getParameter("fname");		
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String con=request.getParameter("con");
		String pan=request.getParameter("pan");
		String aad=request.getParameter("aad");
		String dob=request.getParameter("date");
		
		String pg=request.getParameter("pg");
		String pg1=request.getParameter("pg1");
		String pg2=request.getParameter("pg2");
		String pg3=request.getParameter("pg3");
		String pg4=request.getParameter("pg4");
		
		String ug=request.getParameter("ug1");
		String ug1=request.getParameter("ug2");
		String ug2=request.getParameter("ug3");
		String ug3=request.getParameter("ug4");
		String ug4=request.getParameter("ug5");
	
		String hsc=request.getParameter("hsc");
		String hsc1=request.getParameter("hsc1");
		String hsc2=request.getParameter("hsc2");
		
		String sslc=request.getParameter("sslc");  
		String sslc1=request.getParameter("sslc1");
		String sslc2=request.getParameter("sslc2");
		
		String odetails = request.getParameter("oname1");
		String s="PENDING";
		
		
		java.util.Date now = new java.util.Date();
		 String date=now.toString();
		 String DATE_FORMAT = "dd-MM-yyyy";
		 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	     String strDateNew = sdf.format(now) ;
	     String o= strDateNew;
		
		
		try{  
			 Connection conn = Emp.Databasecon.getconnection();
			
			 String path = Paths.get("").toAbsolutePath().toString(); 
			 String fpath = "D:\\old project\\BLOCKCHAIN_PROJECT\\BLOCK CHAIN\\BLOCK CHAIN\\SOURCE CODE & DATABASE\\Block_chain_Auditor\\Data\\"+pan+".txt";
			 
			 FileWriter fw=new FileWriter("D:\\old project\\BLOCKCHAIN_PROJECT\\BLOCK CHAIN\\BLOCK CHAIN\\SOURCE CODE & DATABASE\\Block_chain_Auditor\\Data\\"+pan+".txt");    
	         
			 fw.write("<-------- PERSONAL DETAILS ------------------------>");
			 fw.write("\n");
			 fw.write("\n");
			 fw.write("NAME        : " + fname +" "+ lname);
	         fw.write("\n");
	         fw.write("EMAIL ID    : "+ email); 
	         fw.write("\n");
	         fw.write("PAN ID      :  "+pan); 
	         fw.write("\n");
	         fw.write("AADHAR ID   : " +aad);
	         fw.write("\n");
	         fw.write("DATE OF BIRTH  : "+dob); 
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("<-------- POST GRADUATE DETAILS ----------------->");
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("COLLEGE NAME      : "+ pg); 
	         fw.write("\n");
	         fw.write("DEGREE AND BRANCH : " + pg1 + " (" + pg2 +" )");
	         fw.write("\n");
	         fw.write("PASSED YEAR       : "+pg3+ ",     PERCENNTAGE : "+pg4+" %");
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("<-------- UNDER GRADUATE DETAILS ---------------->");
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("COLLEGE NAME      : "+ ug); 
	         fw.write("\n");
	         fw.write("DEGREE AND BRANCH : " + ug1 + " (" + ug2 +") ");
	         fw.write("\n");
	         fw.write("PASSED YEAR       : "+ug3+ ",     PERCENNTAGE : "+ug4+" %"); 
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("<-------- HSC DETAILS ------------------------------->");
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("SCHOOL    : "+ hsc); 
	         fw.write("\n");
	         fw.write("PASSED ON : " + hsc1+" PERCENTAGE : "+hsc2+" %");
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("<-------- SSLC DETAILS ------------------------------->");
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("SCHOOL    : "+ sslc); 
	         fw.write("\n");
	         fw.write("PASSED ON : " + sslc1+" PERCENTAGE : "+sslc2+" %");
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("<-------- EXPERIENCE --------------------------------->");
	     	 fw.write("\n");
	     	 fw.write("\n");
		 	 fw.write("ORGANIZATION DETAILS > ");
	         fw.write("\n");
	         fw.write("WORKED ON :  FRESHER" + " :>");
	         fw.write("\n");
	         fw.write("\n");
	         fw.write("-------------------------------------------------------");
	         fw.write("\n");
	         fw.write("DETAILS SUBMITTED DATE : "+ o); 
	         fw.write("\n");
	         fw.write("-------------------------------------------------------");
	         fw.close();
	         // SECOND UPDATED FILE
	         
	         String fpath1 = "D:\\old project\\BLOCKCHAIN_PROJECT\\BLOCK CHAIN\\BLOCK CHAIN\\SOURCE CODE & DATABASE\\Block_chain_Auditor\\Data\\"+pan+"1.txt";
			 FileWriter fw1=new FileWriter("D:\\old project\\BLOCKCHAIN_PROJECT\\BLOCK CHAIN\\BLOCK CHAIN\\SOURCE CODE & DATABASE\\Block_chain_Auditor\\Data\\"+pan+"1.txt");    
			 
			 fw1.write("<-------- PERSONAL DETAILS ------------------------->");
			 fw1.write("\n");
			 fw1.write("\n");
			 fw1.write("NAME        : " + fname +" "+ lname);
	         fw1.write("\n");
	         fw1.write("EMAIL ID    : "+ email); 
	         fw1.write("\n");
	         fw1.write("PAN ID      :  "+pan); 
	         fw1.write("\n");
	         fw1.write("AADHAR ID   : " +aad);
	         fw1.write("\n");
	         fw1.write("DATE OF BIRTH  : "+dob); 
	         fw1.write("\n");
	         fw1.write("\n");
	         fw1.write("<-------- EXPERIENCE -------------------------------->");
	     	 fw1.write("\n");
	     	 fw1.write("\n");
		 	 fw1.write("ORGANIZATION DETAILS > ");
	         fw1.write("\n");
	         fw1.write("WORKED ON : " + odetails +" :>");
	         fw1.write("\n");
	         fw1.write("\n");
	         fw1.write("-----------------------------------------------------");
	         fw1.write("\n");
	         fw1.write("DETAILS SUBMITTED DATE : "+ o); 
	         fw1.write("\n");
	         fw1.write("-----------------------------------------------------");
	         fw1.close();
			 
PreparedStatement ps=conn.prepareStatement("UPDATE resupload SET PG1=?,PG2=?,PG3=?,PG4=?,PG5=?,ODETAILS=?,LOCATION=? where PANID='"+pan+"'");  
	         
	     //  PreparedStatement ps=conn.prepareStatement("insert into resupload values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
		
		int j = 1;
		
		
		ps.setString(j++,pg);
		ps.setString(j++,pg1);
		ps.setString(j++,pg2);
		ps.setString(j++,pg3);
		ps.setString(j++,pg4);
		ps.setString(j++,odetails);
		ps.setString(j++,fpath1);

		

	
		         
		int i=ps.executeUpdate();  
		if(i>0)	
		{
			ses.setAttribute("datapath1", fpath1);
			ses.setAttribute("datapath2", fpath);
			ses.setAttribute("currentdate1", o);
			response.sendRedirect("NewFile2.jsp"); 
		}  
		}
		catch (Exception e2) 
		{
			System.out.println(e2);
			e2.printStackTrace();
		}           
		out.close();
	}
	
}

