package Model;

public class ModelProduit {

	int idProd,qteProd;
	String libelleProd,catProd;
	Double prixProd;
	String file;
	public ModelProduit(int idProd, int qteProd, String libelleProd, String catProd, Double prixProd,String file) {
		super();
		this.idProd = idProd;
		this.qteProd = qteProd;
		this.libelleProd = libelleProd;
		this.catProd = catProd;
		this.prixProd = prixProd;
		this.file=file;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public ModelProduit(){}
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public int getQteProd() {
		return qteProd;
	}
	public void setQteProd(int qteProd) {
		this.qteProd = qteProd;
	}
	public String getLibelleProd() {
		return libelleProd;
	}
	public void setLibelleProd(String libelleProd) {
		this.libelleProd = libelleProd;
	}
	public String getCatProd() {
		return catProd;
	}
	public void setCatProd(String catProd) {
		this.catProd = catProd;
	}
	public Double getPrixProd() {
		return prixProd;
	}
	public void setPrixProd(Double prixProd) {
		this.prixProd = prixProd;
	}
	@Override
	public String toString() {
		return "ModelProduit [idProd=" + idProd + ", qteProd=" + qteProd + ", libelleProd=" + libelleProd + ", catProd="
				+ catProd + ", prixProd=" + prixProd + "]";
	}
	
	
}
