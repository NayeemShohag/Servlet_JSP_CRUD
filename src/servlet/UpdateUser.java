package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import DAO.UserDAO;

public class UpdateUser extends HttpServlet {

	private UserDAO userDAO;
	
	public UpdateUser() {
		// TODO Auto-generated constructor stub
		this.userDAO = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		try {
			updateUser(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private void Userupdate(HttpServletRequest req, HttpServletResponse resp) throws IOException
//	{
//		int id = Integer.parseInt(req.getParameter("id"));
//		String name = req.getParameter("name");
//		String email = req.getParameter("email");
//		String country = req.getParameter("country");
//		User user = new User(id,name,email,country);
//		userDAO.updateUser(user);
//		
//		resp.sendRedirect("users");
//		
//	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String card = request.getParameter("card");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		User user = new User(id, name,card, email, country);
		userDAO.updateUser(user);
		response.sendRedirect("");
	}
}
