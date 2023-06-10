package Metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import Model.ModelClient;
import Model.ModelProduit;
import Model.ModelVente;
public class Vente {

	 private Connection connection;
	 int cmp ;
	    public Vente() {
	        connection = Connexion.getConnection();
	    }

	    public void addVente(ModelVente client,ModelProduit prod) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("INSERT INTO `vente`(`VenteId`, `VenteClient`, `VenteProduit`, `VenteQte`, `VenteDate`) VALUES (null, ?, ?, ?,? )");
	            PreparedStatement preparedStatement2 = connection.
	            		prepareStatement("UPDATE `produit` SET ProdQte=? "
	            				+ "where ProdId=? ");
	            // Parameters start with 1
	        int x=prod.getQteProd()-client.getQteVente();
	            preparedStatement2.setInt(1, x);

	            preparedStatement2.setInt(2, prod.getIdProd());
	            // Parameters start with 1
	            preparedStatement.setInt(1, client.getClt().getClientid());
	            preparedStatement.setInt(2, client.getProd().getIdProd());
	       
	            preparedStatement.setInt(3, client.getQteVente());
	            preparedStatement.setDate(4,  new java.sql.Date(client.getDatevente().getTime()));
	            preparedStatement.executeUpdate();
	            preparedStatement2.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	//updatestock
	    public void updatestock(int qte,ModelProduit p){
	    	int x=p.getQteProd()-qte;
	    	System.out.println("ok"+x);
	    	
			cmp --;
	    }



	    public List<ModelVente> getAllVentes() {
	        List<ModelVente> clients = new ArrayList<ModelVente>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from vente");
	            while (rs.next()) {
	                ModelVente client = new ModelVente();
	          Client c=new Client();
	          Produit p=new Produit();
	         
	                client.setIdVente(rs.getInt("VenteId"));
	                client.setClt(c.getClientById(rs.getInt("VenteClient")));
	                client.setProd( p.getProdById(rs.getInt("VenteProduit")));  
	                client.setQteVente(rs.getInt("VenteQte"));
	                client.setDatevente(rs.getDate("VenteDate"));
	                clients.add(client);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clients;
	    }

	    public ModelVente getVenteById(int clientId) {
	    	  ModelVente client = new ModelVente();
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from vente where VenteId=?");
	            preparedStatement.setInt(1, clientId);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	
	    	          
	                Client c=new Client();
	  	          Produit p=new Produit();
	  	         
	  	                client.setIdVente(rs.getInt("VenteId"));
	  	                client.setClt(c.getClientById(rs.getInt("VenteClient")));
	  	                client.setProd( p.getProdById(rs.getInt("VenteProduit")));  
	  	                client.setQteVente(rs.getInt("VenteQte"));
	  	                client.setDatevente(rs.getDate("VenteDate"));
	  	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return client;
	    }
}
