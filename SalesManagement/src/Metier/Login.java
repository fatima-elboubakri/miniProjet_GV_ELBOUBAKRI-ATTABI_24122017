 package Metier;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.ArrayList;
 import java.util.List;

 import Metier.Login;
import Model.ModelLogin;

public class Login {

	Connection conn = Connexion.getConnection();
	
	public Login(){}
	
	//login
	 public ModelLogin getUserLogin(String login,String pass) {
		 ModelLogin user = new ModelLogin();
	        try {
	            PreparedStatement preparedStatement = conn.
	                    prepareStatement("select * from utilisateur where UserLogin=? and UserPass=?");
	            preparedStatement.setString(1, login);
	            preparedStatement.setString(2, pass);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	 user.setIdlogin(rs.getInt("UserId"));
	                 user.setLogin(rs.getString("UserLogin"));
	                 user.setPass(rs.getString("UserPass"));
	             
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return user;
	    }

}
