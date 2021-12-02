package reto.reto.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteUserDetailService implements UserDetailsService {
    @Value("${spring.lineamiento.usuarioToken}")
    private String usuarioToken;
    @Value("${spring.lineamiento.passwordToken}")
    private String passwordToken;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //  return new User(usuarioToken,passwordToken,new ArrayList<>());
        return new User(usuarioToken,"{noop}" + passwordToken,new ArrayList<>());
    }

}
