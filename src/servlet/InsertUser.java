package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;

public class InsertUser extends HttpServlet {

	private UserDAO userDAO;

	public InsertUser() {
		// TODO Auto-generated constructor stub
		userDAO = new UserDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		try {
			insertUser(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String card = request.getParameter("card");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User newUser = new User(name,card, email, country);
		userDAO.insertUser(newUser);
		response.sendRedirect("");
	}

}
