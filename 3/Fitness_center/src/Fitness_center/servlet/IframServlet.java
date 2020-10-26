package Fitness_center.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Fitness_center.dao.InstructorDao;
import Fitness_center.daofactory.DaoFactory;
import Fitness_center.daofactory.impl.DaoFactoryImpl;
import page.ListPage;

/**
 * Servlet implementation class IframServlet
 */
@WebServlet("/IframServlet")
public class IframServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IframServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoFactory factory=new DaoFactoryImpl();
		InstructorDao userdao=factory.createInstructorDao();
		ListPage list=userdao.list(0,1,"");
		HttpSession session = request.getSession();
        // 将数据存到session中以便于在前台获取
        session.setAttribute("userList", list);
        request.getRequestDispatcher("/html/Usercenter/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
