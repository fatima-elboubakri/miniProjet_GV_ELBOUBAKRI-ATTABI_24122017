package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.Client;

import Metier.Produit;
import Metier.Vente;
import Model.ModelClient;
import Model.ModelProduit;
import Model.ModelVente;

/**
 * Servlet implementation class ProduitWeb
 */
@WebServlet("/VenteWeb")
public class VenteWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/vente.jsp";
    private static String LIST_VENTE= "/vente.jsp";
    private static String VENTE_DETAIL= "/detailvente.jsp";
    private Vente crud;
    private Client clt;
    private Produit prod;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenteWeb() {
        super();
        crud = new Vente();
        clt=new Client();
        prod=new Produit();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int clientId = Integer.parseInt(request.getParameter("clientId"));
           // crud.deleteVente(clientId);
            forward = LIST_VENTE;
            request.setAttribute("users", crud.getAllVentes());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            ModelVente client = crud.getVenteById(clientId);
            request.setAttribute("client", client);
        } else if (action.equalsIgnoreCase("listProduit")){
        	 PrintWriter out=response.getWriter();  
            
             HttpSession session=request.getSession(false);  
             if(session!=null){  
             
            	 String name=(String)session.getAttribute("name");  
               
             //out.print("Hello, "+name+" Welcome to Profile");  
            	 request.setAttribute("clients", crud.getAllVentes());
                 request.setAttribute("name",name);
             request.getRequestDispatcher(LIST_VENTE).include(request, response); 
            
             }  
             else{  
                 out.print("Please login first");  
                 request.getRequestDispatcher("login.jsp").include(request, response);  
             }  
             out.close();  
           
        } else {
            forward = INSERT_OR_EDIT;
   
           
            request.setAttribute("clt", clt.getAllClients());
            request.setAttribute("prod",prod.getAllProduits());
            request.setAttribute("clients", crud.getAllVentes());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ModelVente client = new ModelVente();
		  Client c=new Client();
	       Produit p=new Produit();
	        client.setProd(p.getProdById(Integer.parseInt(request.getParameter("produit"))));
	        client.setClt(c.getClientById(Integer.parseInt(request.getParameter("cltvente"))));  
	        client.setQteVente(Integer.parseInt(request.getParameter("qtevente")));
	       
			try {
				 Date dd = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dat"));
				client.setDatevente(dd);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        String clientid = request.getParameter("venteid");
	        if(clientid == null || clientid.isEmpty())
	        {
	         
	          ModelProduit po=  p.getProdById(Integer.parseInt(request.getParameter("produit")));
	          crud.addVente(client,po);
	            
	        }
	        else
	        {
	            client.setIdVente(Integer.parseInt(clientid));
	           // crud.updateProd(client);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST_VENTE);
	        request.setAttribute("clients", crud.getAllVentes());
	        view.forward(request, response);
	}

}
