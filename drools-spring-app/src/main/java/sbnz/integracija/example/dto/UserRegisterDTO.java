package sbnz.integracija.example.dto;

public class UserRegisterDTO {
	private String email;
	private String password;
	private String lastname;
	private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserRegisterDTO(String email, String password, String lastname, String name) {
		super();
		this.email = email;
		this.password = password;
		this.lastname = lastname;
		this.name = name;
	}
	public UserRegisterDTO() {
		super();
	}
	
	

}
