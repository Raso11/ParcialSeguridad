package pe.edu.upc.aaw.demo1_202302_si63.serviceimplements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Users;
import pe.edu.upc.aaw.demo1_202302_si63.repositories.UserRepository;



//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository rasorepo;

    @Override
    public UserDetails loadUserByUsername(String rasousername) throws UsernameNotFoundException {
        Users rasouser = rasorepo.findByRasousername(rasousername);

        if(rasouser == null) {
            throw new UsernameNotFoundException(String.format("User not exists", rasousername));
        }

        List<GrantedAuthority> rasoroles = new ArrayList<>();

        rasouser.getRoles().forEach(rasorol -> {
            rasoroles.add(new SimpleGrantedAuthority(rasorol.getRasorol()));
        });

        UserDetails rasoud = new org.springframework.security.core.userdetails.User(rasouser.getUsername(), rasouser.getPassword(), rasouser.getEnabled(), true, true, true, rasoroles);

        return rasoud;
    }
}