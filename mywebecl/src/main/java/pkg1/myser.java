package pkg1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myser
 */
@WebServlet("/myser")
public class myser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username=request.getParameter("username");
		String password =request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("helllo");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247/msc3it12","msc3it12","sumo@123");
			
//			PreparedStatement pst= con.prepareStatement("SELECT * FROM login WHERE username=? AND password=?");
			PreparedStatement pst= con.prepareStatement("insert into login values (?,?)");
			
			pst.setString(1, username);
			pst.setString(2, password);
			
			int rs=pst.executeUpdate();
			
			if(rs!=0)
			{
				response.sendRedirect("sus.jsp");
				
			}
			else
			{
				response.sendRedirect("er.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			}
	
	}

}
