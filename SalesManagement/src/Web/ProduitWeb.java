package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import Metier.Produit;
import Model.ModelProduit;

/**
 * Servlet implementation class ProduitWeb
 */
@WebServlet("/ProduitWeb")
@MultipartConfig
(maxFileSize=1024*1024*10)     // 10MB
public class ProduitWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String path = "C:/Users/adm/J2EEprojects/SalesManagement/WebContent/IMAGES/";
    private static String INSERT_OR_EDIT = "/produit.jsp";
    private static String LIST_CLIENT= "/listProduit.jsp";
    private Produit crud;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitWeb() {
        super();
        crud = new Produit();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            crud.deleteProd(clientId);
            forward = LIST_CLIENT;
            request.setAttribute("users", crud.getAllProduits());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            ModelProduit client = crud.getProdById(clientId);
            request.setAttribute("client", client);
        } else if (action.equalsIgnoreCase("listProduit")){
        	 PrintWriter out=response.getWriter();  
            
             HttpSession session=request.getSession(false);  
             if(session!=null){  
             
            	 String name=(String)session.getAttribute("name");  
               
             //out.print("Hello, "+name+" Welcome to Profile");  
            	 request.setAttribute("clients", crud.getAllProduits());
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
		 ModelProduit client = new ModelProduit();
	        client.setLibelleProd(request.getParameter("libelle"));
	        client.setCatProd(request.getParameter("category"));  
	        client.setQteProd(Integer.parseInt(request.getParameter("qte")));
	        client.setPrixProd(Double.parseDouble(request.getParameter("prix")));
	        Part part1 = request.getPart("image");
			String filetypeCover = part1.getContentType();
		

			String extcover = GetExtension(filetypeCover);
		
			
			//date
			SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
			//System.out.println(formater.format(new Date()));
			String filenameCover = "img_"+formater.format(new Date())+"."+extcover;
		

			String coverpath = path+filenameCover;
		
			part1.write(coverpath);
	
			System.out.println(coverpath);
		
			client.setFile(filenameCover);
	        String clientid = request.getParameter("clientid");
	        if(clientid == null || clientid.isEmpty())
	        {
	            crud.addProd(client);
	        }
	        else
	        {
	            client.setIdProd(Integer.parseInt(clientid));
	            crud.updateProd(client);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENT);
	        request.setAttribute("clients", crud.getAllProduits());
	        view.forward(request, response);
	}
	public static String GetExtension(String s){
		String[] parts = s.split("/");
		String part2 = parts[1];
		return part2;
	}

}
