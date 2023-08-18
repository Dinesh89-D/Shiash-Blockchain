package Emp;

import java.sql.*;  
  
public class EmpDAO {  
public static boolean validate(String name,String pass){  
boolean status=false;  
try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/blockchain_auditor","root","root"); 
      
PreparedStatement ps=con.prepareStatement(  
"select * from empreg where EMAIL=? and PASSWORD=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}
catch(Exception e){System.out.println(e);}  
return status;  
}


public static boolean validate2(String name,String pass){  
boolean status=false;  
try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/blockchain_auditor","root","root"); 
      
PreparedStatement ps=con.prepareStatement(  
"select * from keygeneration where username=? and pass=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}
catch(Exception e){System.out.println(e);}  
return status;  
}  
}  