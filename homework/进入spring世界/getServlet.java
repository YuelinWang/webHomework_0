package wyl.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.support.WebApplicationContextUtils;
import wyl.getString.SpringMsg;
/**
 * Servlet implementation class getServlet
 */
@WebServlet("/getServlet")
public class getServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		getMyString sno = (getMyString) applicationContext.getBean("getmyString");*/
		String fwPage="/myString.jsp";
		SpringMsg sno=(SpringMsg)WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()).getBean("myString");
		request.setAttribute("sno", sno.getMsg());
		request.getRequestDispatcher(fwPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



