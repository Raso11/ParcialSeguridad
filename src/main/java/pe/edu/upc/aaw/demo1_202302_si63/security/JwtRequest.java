package pe.edu.upc.aaw.demo1_202302_si63.security;
import java.io.Serializable;

/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//Clase 4
@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class JwtRequest implements Serializable {
	private static final long rasoserialVersionUID = 5926468583005150707L;
	private String rasousername;
	private String rasopassword;
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtRequest(String rasousername, String rasopassword) {
		super();
		this.rasousername = rasousername;
		this.rasopassword = rasopassword;
	}
	public static long getSerialversionuid() {
		return rasoserialVersionUID;
	}
	public String getUsername() {
		return rasousername;
	}
	public String getPassword() {
		return rasopassword;
	}
	public void setUsername(String rasousername) {
		this.rasousername = rasousername;
	}
	public void setPassword(String rasopassword) {
		this.rasopassword = rasopassword;
	}
}