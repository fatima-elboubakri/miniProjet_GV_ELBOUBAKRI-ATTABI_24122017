package Model;

public class ModelClient {

    int clientid;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
	public ModelClient(int clientid, String firstName, String lastName, String email, String telephone) {
		super();
		this.clientid = clientid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.telephone = telephone;
	}
    
	public ModelClient(){}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "ModelClient [clientid=" + clientid + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", telephone=" + telephone + "]";
	};
	
   
}
