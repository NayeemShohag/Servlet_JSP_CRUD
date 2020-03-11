package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;

public class UserList extends HttpServlet {

	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserList() {
		this.userDAO = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		try {
			listUser(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void listUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException {
		List<User> listUser = userDAO.selectAllUsers();

		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
		// System.out.println("here");
	}
}
