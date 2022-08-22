package sn.kai.kaivoiture.Config;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sn.kai.kaivoiture.service.UserDetailsServiceImplement;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthentificationFilter  extends OncePerRequestFilter {
    @Autowired
    private UserDetailsServiceImplement userDetailsService;
    @Autowired
    private  JwTUtils jwTUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
   request.getHeader("Authorization");
      final   String requesteTokenherder = request.getHeader("Authorization");
        System.out.println(requesteTokenherder);
        String username = null;
        String jwtToken = null;
        if(requesteTokenherder!=null && requesteTokenherder.startsWith("Bearer ")){
            jwtToken = requesteTokenherder.substring(7);
            try {
                username = jwTUtil.extractUsername(jwtToken);
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                System.out.println(" token has been expired");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(" invalid token");
            }

        }else {
            System.out.println("invalide token");
        }
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            System.out.println("username is not null");
          final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(jwTUtil.validateToken(jwtToken,userDetails)){
                System.out.println("token is valid");
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                        }
        }else {
            System.out.println("token is not valid");
        }
        filterChain.doFilter(request,response);
    }

}

