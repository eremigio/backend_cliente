package reto.reto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reto.reto.util.AuthenticationRequest;
import reto.reto.util.AuthenticationResponse;
import reto.reto.util.ClienteUserDetailService;
import reto.reto.util.JWTconfig;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClienteUserDetailService clienteUserDetailService;

    @Autowired
    private JWTconfig jwTconfig;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> creaToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            UserDetails userDetails = clienteUserDetailService.loadUserByUsername(request.getUsername());
            String jwt = jwTconfig.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
