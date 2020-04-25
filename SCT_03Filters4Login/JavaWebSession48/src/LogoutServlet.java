

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout-servlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("user");
        if(username!=null){
            session.invalidate();
            request.setAttribute("logoutsuccess", "已注销！请重新登录");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            request.setAttribute("unlogin", "请您先登录");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
