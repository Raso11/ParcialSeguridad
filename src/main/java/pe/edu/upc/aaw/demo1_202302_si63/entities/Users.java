package pe.edu.upc.aaw.demo1_202302_si63.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rasoid;

	@Column(length = 30, unique = true)
	private String rasousername;
	@Column(length = 200)
	private String rasopassword;
	private Boolean rasoenabled;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> rasoroles;

	public Long getId() {
		return rasoid;
	}

	public void setId(Long rasoid) {
		this.rasoid = rasoid;
	}

	public String getUsername() {
		return rasousername;
	}

	public void setUsername(String rasousername) {
		this.rasousername = rasousername;
	}

	public String getPassword() {
		return rasopassword;
	}

	public void setPassword(String rasopassword) {
		this.rasopassword = rasopassword;
	}

	public Boolean getEnabled() {
		return rasoenabled;
	}

	public void setEnabled(Boolean rasoenabled) {
		this.rasoenabled = rasoenabled;
	}

	public List<Role> getRoles() {
		return rasoroles;
	}

	public void setRoles(List<Role> rasoroles) {
		this.rasoroles = rasoroles;
	}

}