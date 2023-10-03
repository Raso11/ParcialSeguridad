package pe.edu.upc.aaw.demo1_202302_si63.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//Clase 7
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long rasoserialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest rasorequest, HttpServletResponse rasoresponse,
                         AuthenticationException rasoauthException) throws IOException {

        rasoresponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
