public class UserService {
	String JSP_DIR="html/Usercenter";
	private InstructorDao userMrg = null;
	public static final String EDIT_ACTION = "edit";
    public static final String DEL_ACTION = "del";
    public static final String LIST_ACTION = "list";

    public UserService() {
    	DaoFactory factory=new DaoFactoryImpl();
		this.userMrg=factory.createInstructorDao();
    }
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String myaction = request.getParameter("myaction");
    	String page = null;
        switch (myaction) {
            case EDIT_ACTION:
                page = onEdit(request, response);
                break;
            case DEL_ACTION:
                page = onDel(request, response);
                break;
            default:
                page = onList(request, response);
        }
        return page;
    }
    public String onDel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String page = "/user.jsp";
        DaoFactory factory=new DaoFactoryImpl();
		InstructorDao userdao=factory.createInstructorDao();
		userdao.delete(request.getParameter("rname"));
		int pageNos;
        if (request.getParameter("beginIndex") == null
                || Integer.parseInt(request.getParameter("beginIndex")) < 1) {
            pageNos = 1;
        } else {
            pageNos = Integer.parseInt(request.getParameter("beginIndex"));
        }
		ListPage list=userMrg.list(pageNos,2,"");
		HttpSession session = request.getSession();
        // 将数据存到session中以便于在前台获取
        session.setAttribute("userList", list);
        return JSP_DIR+page;
    }
    public String onList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 String page="/user.jsp";
         int pageNos;
         if (request.getParameter("beginIndex") == null
                 || Integer.parseInt(request.getParameter("beginIndex")) < 1) {
             pageNos = 1;
         } else {
             pageNos = Integer.parseInt(request.getParameter("beginIndex"));
         }
 		ListPage list=userMrg.list(pageNos,2,"");
 		HttpSession session = request.getSession();
         // 将数据存到session中以便于在前台获取
         session.setAttribute("userList", list);
         return JSP_DIR+page；
    }
}