package wyl.servlet;

import java.io.IOException;
/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname="173401010517";
		String upwd="wyl";
		String testuname=request.getParameter("rname");
		String testupwd=request.getParameter("rpass");
		if(testuname==""||testupwd==""||!uname.equals(testuname)||!upwd.equals(testupwd)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
			out.print("<script>");
			out.print("alert('用户不存在或密码错误');");
			out.print("window.location.href='/wyl/login.jsp'");
			out.print("</script>");
			out.close();
		}else {
			HttpSession session = request.getSession();
	        session.setAttribute("username", uname); 
	        response.sendRedirect("/wyl/admin/success.jsp");
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