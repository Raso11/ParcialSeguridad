package pe.edu.upc.aaw.demo1_202302_si63.security;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import pe.edu.upc.aaw.demo1_202302_si63.serviceimplements.JwtUserDetailsService;


//Clase 6
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUserDetailsService rasojwtUserDetailsService;
	@Autowired
	private JwtTokenUtil rasojwtTokenUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest rasorequest, HttpServletResponse rasoresponse, FilterChain rasochain)
			throws ServletException, IOException {
		final String rasorequestTokenHeader = rasorequest.getHeader("Authorization");
		String rasousername = null;
		String rasojwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		if (rasorequestTokenHeader != null && rasorequestTokenHeader.startsWith("Bearer ")) {
			//jwtToken = requestTokenHeader.substring(7);
			rasojwtToken = rasorequestTokenHeader.split(" ")[1].trim();

			try {
				rasousername = rasojwtTokenUtil.getUsernameFromToken(rasojwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("No se puede encontrar el token JWT");
			} catch (ExpiredJwtException e) {
				System.out.println("Token JWT ha expirado");
			}
		} else {
			logger.warn("JWT Token no inicia con la palabra Bearer");
		}

		// Once we get the token validate it.
		if (rasousername != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails rasouserDetails = this.rasojwtUserDetailsService.loadUserByUsername(rasousername);

			// if token is valid configure Spring Security to manually set
			// authentication
			if (rasojwtTokenUtil.validateToken(rasojwtToken, rasouserDetails)) {

				UsernamePasswordAuthenticationToken rasousernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						rasouserDetails, null, rasouserDetails.getAuthorities());
				rasousernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(rasorequest));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(rasousernamePasswordAuthenticationToken);
			}
		}
		rasochain.doFilter(rasorequest, rasoresponse);
	}
}
