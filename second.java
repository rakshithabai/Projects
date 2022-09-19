import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/second")
public class second extends GenericServlet 
{
public void init()
{
	System.out.println("this is init");
}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String a=req.getParameter("t1");
		String b=req.getParameter("t2");
		String c=req.getParameter("t3");
		String but=req.getParameter("b1");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			if(but.equals("insert"))
			{
				PreparedStatement ps=con.prepareStatement("insert into insurance values(?,?,?)");
				ps.setInt(1,Integer.parseInt(a));
				ps.setString(2,b);
				ps.setString(3,c);
				ps.execute();
				pw.println("row inserted");
			}
			
			else
			{
				pw.println("invalid input");
			}
		}
			catch(Exception ae)
			{
				ae.printStackTrace();
			}
}
		public void destroy()
	{
		System.out.println("this is destroy");
	}}