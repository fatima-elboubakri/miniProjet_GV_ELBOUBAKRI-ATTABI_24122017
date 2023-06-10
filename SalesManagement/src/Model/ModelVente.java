package Model;

import java.util.Date;

public class ModelVente {
int idVente,qteVente;
ModelProduit prod;
ModelClient clt;
Date datevente;
public ModelVente(int idVente, int qteVente, ModelProduit prod, ModelClient clt, Date datevente) {
	super();
	this.idVente = idVente;
	this.qteVente = qteVente;
	this.prod = prod;
	this.clt = clt;
	this.datevente = datevente;
}
public ModelVente() {
	// TODO Auto-generated constructor stub
}
public int getIdVente() {
	return idVente;
}
public void setIdVente(int idVente) {
	this.idVente = idVente;
}
public int getQteVente() {
	return qteVente;
}
public void setQteVente(int qteVente) {
	this.qteVente = qteVente;
}
public ModelProduit getProd() {
	return prod;
}
public void setProd(ModelProduit prod) {
	this.prod= prod;
}
public ModelClient getClt() {
	return clt;
}
public void setClt(ModelClient clt) {
	this.clt = clt;
}
public Date getDatevente() {
	return datevente;
}
public void setDatevente(Date datevente) {
	this.datevente = datevente;
}
@Override
public String toString() {
	return "ModelVente [idVente=" + idVente + ", qteVente=" + qteVente + ", prod=" + prod + ", clt=" + clt
			+ ", datevente=" + datevente + "]";
}



}
