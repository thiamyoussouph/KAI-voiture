package sn.kai.kaivoiture.Web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Config.JwTUtils;
import sn.kai.kaivoiture.Entites.JwtRequest;
import sn.kai.kaivoiture.Entites.JwtResponse;
import sn.kai.kaivoiture.Entites.User;
import sn.kai.kaivoiture.service.UserDetailsServiceImplement;

import java.security.Principal;


@RestController

@CrossOrigin("*")
public class AuthentificationController {
 @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
 private UserDetailsServiceImplement userDetailsServiceImplement;
    @Autowired
    private JwTUtils jwTUtils;
    @PostMapping("/generer-token")
    public ResponseEntity<?>generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
       try {
           authentification(jwtRequest.getUsername(), jwtRequest.getPassword());
         } catch (UsernameNotFoundException e) {
           e.printStackTrace();
             throw new Exception("Invalid username/password supplied");
         }
      UserDetails userDetails =this.userDetailsServiceImplement.loadUserByUsername(jwtRequest.getUsername());

  String token= this.jwTUtils.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authentification( String username, String password) throws Exception {
        try {

    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        } catch (DisabledException e) {
            throw new Exception("User is disabled!"+e.getMessage());
        }catch (BadCredentialsException e) {
            throw new Exception("Bad credentials!" +e.getMessage());
        }
    }
@GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {

        return ((User)this.userDetailsServiceImplement.loadUserByUsername(principal.getName()));

    }
}
