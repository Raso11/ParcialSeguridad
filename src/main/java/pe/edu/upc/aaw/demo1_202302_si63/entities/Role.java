package pe.edu.upc.aaw.demo1_202302_si63.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "rasorol" }) })
public class Role implements Serializable {

	private static final long rasoserialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rasoid;

	private String rasorol;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private Users rasouser;
	
	
	//GETTERS AND SETTERES


	public Long getRasoid() {
		return rasoid;
	}

	public void setRasoid(Long rasoid) {
		this.rasoid = rasoid;
	}

	public String getRasorol() {
		return rasorol;
	}

	public void setRasorol(String rasorol) {
		this.rasorol = rasorol;
	}

	public Users getRasouser() {
		return rasouser;
	}

	public void setRasouser(Users rasouser) {
		this.rasouser = rasouser;
	}
}