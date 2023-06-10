package Model;

public class ModelLogin {
int idlogin;
String login,pass;


public ModelLogin(int idlogin, String login, String pass) {
	super();
	this.idlogin = idlogin;
	this.login = login;
	this.pass = pass;
}
public ModelLogin() {}
public int getIdlogin() {
	return idlogin;
}
public void setIdlogin(int idlogin) {
	this.idlogin = idlogin;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
@Override
public String toString() {
	return "ModelLogin [idlogin=" + idlogin + ", login=" + login + ", pass=" + pass + "]";
}

}
