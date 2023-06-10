package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.Client;
import Model.ModelClient;

/**
 * Servlet implementation class ClientWeb
 */
@WebServlet("/ClientWeb")
public class ClientWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/client.jsp";
    private static String LIST_CLIENT= "/listClient.jsp";
    private Client crud;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientWeb() {
        super();
        crud = new Client();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            crud.deleteClient(clientId);
            forward = LIST_CLIENT;
            request.setAttribute("users", crud.getAllClients());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            ModelClient client = crud.getClientById(clientId);
            request.setAttribute("client", client);
        } else if (action.equalsIgnoreCase("listClient")){
        	 PrintWriter out=response.getWriter();  
            
             HttpSession session=request.getSession(false);  
             if(session!=null){  
             
            	 String name=(String)session.getAttribute("name");  
               
             //out.print("Hello, "+name+" Welcome to Profile");  
            	 request.setAttribute("clients", crud.getAllClients());
                 request.setAttribute("name",name);
             request.getRequestDispatcher(LIST_CLIENT).include(request, response); 
            
             }  
             else{  
                 out.print("Please login first");  
                 request.getRequestDispatcher("login.jsp").include(request, response);  
             }  
             out.close();  
           
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ModelClient client = new ModelClient();
	        client.setFirstName(request.getParameter("firstName"));
	        client.setLastName(request.getParameter("lastName"));
	       
	        client.setEmail(request.getParameter("email"));
	        client.setTelephone(request.getParameter("telephone"));
	        String clientid = request.getParameter("clientid");
	        if(clientid == null || clientid.isEmpty())
	        {
	            crud.addClient(client);
	        }
	        else
	        {
	            client.setClientid(Integer.parseInt(clientid));
	            crud.updateClient(client);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENT);
	        request.setAttribute("clients", crud.getAllClients());
	        view.forward(request, response);
	}

}
