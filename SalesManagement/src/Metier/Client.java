package Metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.ModelClient;
import Metier.Connexion;

public class Client{

    private Connection connection;

    public Client() {
        connection = Connexion.getConnection();
    }

    public void addClient(ModelClient client) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `client`(`CltId`, `CltNom`, `CltPrenom`, `CltEmail`, `CltTel`) VALUES (null, ?, ?, ?,? )");
            // Parameters start with 1
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
       
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getTelephone());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from client where CltId=?");
            // Parameters start with 1
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(ModelClient client) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE `client` SET `CltNom`=?,`CltPrenom`=?,`CltEmail`=?,`CltTel`=? "
                    		+ "where CltId=?");
            // Parameters start with 1
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
   
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getTelephone());
            preparedStatement.setInt(5, client.getClientid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ModelClient> getAllClients() {
        List<ModelClient> clients = new ArrayList<ModelClient>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from client");
            while (rs.next()) {
                ModelClient client = new ModelClient();
                client.setClientid(rs.getInt("CltId"));
                client.setFirstName(rs.getString("CltNom"));
                client.setLastName(rs.getString("CltPrenom"));  
                client.setEmail(rs.getString("CltEmail"));
                client.setTelephone(rs.getString("CltTel"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public ModelClient getClientById(int clientId) {
        ModelClient client = new ModelClient();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from client where CltId=?");
            preparedStatement.setInt(1, clientId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	client.setClientid(rs.getInt("CltId"));
                client.setFirstName(rs.getString("CltNom"));
                client.setLastName(rs.getString("CltPrenom"));  
                client.setEmail(rs.getString("CltEmail"));
                client.setTelephone(rs.getString("CltTel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }
}