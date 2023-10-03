package pe.edu.upc.aaw.demo1_202302_si63.security;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//Clase 1
@Component
public class JwtTokenUtil implements Serializable {

    private static final long rasoserialVersionUID = -2550185165626007488L;

    //milisegundos || 18 minutos, le quitamos mil 18 segundos demo
    public static final long rasoJWT_TOKEN_VALIDITY = 7 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String rasosecret;

    //retrieve username from jwt token
    public String getUsernameFromToken(String rasotoken) {
        return getClaimFromToken(rasotoken, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String rasotoken) {
        return getClaimFromToken(rasotoken, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String rasotoken, Function<Claims, T> rasoclaimsResolver) {
        final Claims rasoclaims = getAllClaimsFromToken(rasotoken);
        return rasoclaimsResolver.apply(rasoclaims);
    }
    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String rasotoken) {
        return Jwts.parser().setSigningKey(rasosecret).parseClaimsJws(rasotoken).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String rasotoken) {
        final Date rasoexpiration = getExpirationDateFromToken(rasotoken);
        return rasoexpiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails rasouserDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("nombre", "rafael");
        claims.put("role",rasouserDetails.getAuthorities().stream().map(rasor->rasor.getAuthority()).collect(Collectors.joining()));
        return doGenerateToken(claims, rasouserDetails.getUsername());
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> rasoclaims, String rasosubject) {

        return Jwts.builder().setClaims(rasoclaims).setSubject(rasosubject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + rasoJWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, rasosecret).compact();
    }

    //validate token
    public Boolean validateToken(String rasotoken, UserDetails rasouserDetails) {
        final String rasousername = getUsernameFromToken(rasotoken);
        return (rasousername.equals(rasouserDetails.getUsername()) && !isTokenExpired(rasotoken));
    }
}