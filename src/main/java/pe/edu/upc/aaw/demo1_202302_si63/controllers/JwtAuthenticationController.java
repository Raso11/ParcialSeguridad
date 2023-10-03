package pe.edu.upc.aaw.demo1_202302_si63.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.demo1_202302_si63.security.JwtRequest;
import pe.edu.upc.aaw.demo1_202302_si63.security.JwtResponse;
import pe.edu.upc.aaw.demo1_202302_si63.security.JwtTokenUtil;
import pe.edu.upc.aaw.demo1_202302_si63.serviceimplements.JwtUserDetailsService;


//Clase 3
@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager rasoauthenticationManager;
	@Autowired
	private JwtTokenUtil rasojwtTokenUtil;
	@Autowired
	private JwtUserDetailsService rasouserDetailsService;
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest rasoauthenticationRequest) throws Exception {
		authenticate(rasoauthenticationRequest.getUsername(), rasoauthenticationRequest.getPassword());
		final UserDetails rasouserDetails = rasouserDetailsService.loadUserByUsername(rasoauthenticationRequest.getUsername());
		final String rasotoken = rasojwtTokenUtil.generateToken(rasouserDetails);
		return ResponseEntity.ok(new JwtResponse(rasotoken));
	}
	private void authenticate(String rasousername, String rasopassword) throws Exception {
		try {
			rasoauthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(rasousername, rasopassword));
		} catch (DisabledException rasoe) {
			throw new Exception("USER_DISABLED", rasoe);
		} catch (BadCredentialsException rasoe) {
			throw new Exception("INVALID_CREDENTIALS", rasoe);
		}
	}
}