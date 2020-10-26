package Fitness_center.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fitness_center.dao.InstructorDao;
import Fitness_center.daofactory.DaoFactory;
import Fitness_center.daofactory.impl.DaoFactoryImpl;
import Fitness_center.vo.InstructorVo;

/**
 * Servlet implementation class myservlet
 */
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF8");
		InstructorVo record = new InstructorVo();
		String rname=request.getParameter("rname");
		record.setrname(rname);
		String rpass=request.getParameter("rpass");
		record.setrpass(rpass);
		String sex=new String(request.getParameter("sex"));
		record.setsex(sex);
		String date=request.getParameter("date");
		record.setdate(date);
		String email=request.getParameter("email");
		record.setemail(email);
		String tel=request.getParameter("tel");
		record.settel(tel);
		String character=request.getParameter("character");
		record.setcharacter(character);
		String grade=request.getParameter("grade");;
		if(character=="管理员"){
			grade="1";
		}
		System.out.println(grade);
		record.setgrade(grade);
		String all_hobby[]=request.getParameterValues("hobby");
		String hobby="";
		for(int i=0;i<all_hobby.length;i++) {
			hobby+=all_hobby[i];
			hobby+=",";
		}
		System.out.println(hobby);
		record.sethobby(hobby);
		String personal=request.getParameter("personal");
		record.setpersonal(personal);
		DaoFactory factory=new DaoFactoryImpl();
		InstructorDao userdao=factory.createInstructorDao();
		try {
			userdao.insert(record);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
			out.print("<script>");
			out.print("alert('注册成功');");
			out.print("window.location.href='/Fitness_center/html/index.html'");
			out.print("</script>");
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
			out.print("<script>");
			out.print("alert('注册失败，请检查输入的信息！！');");
			out.print("window.location.href='/Fitness_center/html/register.html'");
			out.print("</script>");
			out.close();
		}finally {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
