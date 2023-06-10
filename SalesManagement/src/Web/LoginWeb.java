package Web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Metier.Login;
import Model.ModelLogin;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession; 
/**
 * Servlet implementation class LoginWeb
 */
@WebServlet("/LoginWeb")
public class LoginWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        PrintWriter out=response.getWriter();  
        if (action.equalsIgnoreCase("logout")){
        	  
            
                 
              
                 
               HttpSession session=request.getSession();  
               session.invalidate();  
                 
               out.print("You are successfully logged out!");  
               RequestDispatcher view = request.getRequestDispatcher("login.jsp");
      
               view.forward(request, response);
               ///out.close();     
        } else {
        	request.getRequestDispatcher("/index.jsp").include(request, response); 
        	 out.print(" log out failed!"); 
        }

       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)  
             throws ServletException, IOException {  
 response.setContentType("text/html");  
 PrintWriter out=response.getWriter();  
 
   
		 String name=request.getParameter("login");  
	        String password=request.getParameter("pass");  
	        ModelLogin modellogin=new ModelLogin();
	        Login login=new Login();
	        modellogin=login.getUserLogin(name, password);
	        String nameBD=modellogin.getLogin();  
	        String passwordBD=modellogin.getPass(); 
	        if(password.equals(passwordBD) && name.equals(nameBD)){  
	        	out.print("<script>alert('Login Success! ')</script>"); 
	        	out.print("Hello, "+name+" Welcome to Profile"); 
	        HttpSession session=request.getSession();  
	        session.setAttribute("name",name);  
	        request.getRequestDispatcher("index.jsp").include(request, response);  
	        request.setAttribute("name",name);
	        }  
	        else{  
	        	out.print("<script>alert('Sorry, username or password error! ')</script>");  
	            request.getRequestDispatcher("login.jsp").include(request, response);  
	        }  
	        out.close();  
	}

}
