
import java.sql.*;  
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServl
 */
@WebServlet("/LoginServl")
public class LoginServl extends HttpServlet {
	
	public static boolean validate(String n,String p){
	    boolean status=false;  
	    try{  
	    	Class.forName("oracle.jdbc.driver.OracleDriver");  
	    	Connection con=DriverManager.getConnection(  
	    	"jdbc:oracle:thin:@localhost:1521:xe","system","1234");  
	    	      
	    	PreparedStatement ps=con.prepareStatement("select * from insurance where email=? and password=?");  
	    	ps.setString(1,n);  
	    	ps.setString(2,p);  
	    	      
	    	ResultSet rs=ps.executeQuery();  
	    	status=rs.next();  
	    	          
	    	}catch(Exception e)
	        { 
	    		System.out.println(e);
	        }  
	    	return status;  
	    	}  
	}
	