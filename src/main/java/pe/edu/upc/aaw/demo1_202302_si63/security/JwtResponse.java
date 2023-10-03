package pe.edu.upc.aaw.demo1_202302_si63.security;
import java.io.Serializable;

/*
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

clase 5
@AllArgsConstructor
@Getter*/
public class JwtResponse implements Serializable {

	private static final long rasoserialVersionUID = -8091879091924046844L;
	private final String rasojwttoken;

	public String getJwttoken() {
		return rasojwttoken;
	}

	public JwtResponse(String rasojwttoken) {
		super();
		this.rasojwttoken = rasojwttoken;
	}

}