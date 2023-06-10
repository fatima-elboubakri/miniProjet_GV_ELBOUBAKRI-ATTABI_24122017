package Metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.ModelProduit;
import Metier.Connexion;

public class Produit{

    private Connection connection;

    public Produit() {
        connection = Connexion.getConnection();
    }

    public void addProd(ModelProduit client) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `produit`(`ProdId`, `ProdLibelle`, `ProdCategory`, `ProdQte`, `ProdPrix`, `ProdFile`)"
                    		+ " VALUES (null, ?, ?, ?,?,? )");
            // Parameters start with 1
            preparedStatement.setString(1, client.getLibelleProd());
            preparedStatement.setString(2, client.getCatProd());
       
            preparedStatement.setInt(3, client.getQteProd());
            preparedStatement.setDouble(4, client.getPrixProd());
            preparedStatement.setString(5, client.getFile());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProd(int clientId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from produit where ProdId=?");
            // Parameters start with 1
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProd(ModelProduit client) {
        try {
            PreparedStatement preparedStatement = connection.
            		prepareStatement("UPDATE `produit` SET ProdLibelle=?,ProdCategory=?,ProdQte=?,ProdPrix=?,ProdFile=? where ProdId=? ");
            // Parameters start with 1
            preparedStatement.setString(1, client.getLibelleProd());
            preparedStatement.setString(2, client.getCatProd());
            preparedStatement.setInt(3, client.getQteProd());
            preparedStatement.setDouble(4, client.getPrixProd());
            preparedStatement.setString(5, client.getFile());
            preparedStatement.setInt(6, client.getIdProd());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ModelProduit> getAllProduits() {
        List<ModelProduit> clients = new ArrayList<ModelProduit>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from produit");
            while (rs.next()) {
                ModelProduit client = new ModelProduit();
                client.setLibelleProd(rs.getString("ProdLibelle"));
                client.setCatProd(rs.getString("ProdCategory"));  
                client.setQteProd(rs.getInt("ProdQte"));
                client.setIdProd(rs.getInt("ProdId")); 
                client.setPrixProd(rs.getDouble("ProdPrix"));
                client.setFile(rs.getString("ProdFile"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public ModelProduit getProdById(int clientId) {
        ModelProduit client = new ModelProduit();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from produit where ProdId=?");
            preparedStatement.setInt(1, clientId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 client.setLibelleProd(rs.getString("ProdLibelle"));
                 client.setCatProd(rs.getString("ProdCategory"));  
                 client.setQteProd(rs.getInt("ProdQte"));
                 client.setIdProd(rs.getInt("ProdId")); 
                 client.setPrixProd(rs.getDouble("ProdPrix"));
                 client.setFile(rs.getString("ProdFile"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }
}