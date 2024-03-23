package br.com.eduardonunesdev.educafacil.config.security;

import br.com.eduardonunesdev.educafacil.services.JwtService;
import br.com.eduardonunesdev.educafacil.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final short START_TOKEN_INDEX = 7;
    private final JwtService jwtService;
    private final UserService userService;

    public SecurityFilter(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String jwtToken;
        String header = request.getHeader("Authorization");
        if(tokenPresent(header)){
            jwtToken = header.substring(START_TOKEN_INDEX);
            var username = jwtService.validateToken(jwtToken);
            addUserToContext(username);
        }

        filterChain.doFilter(request, response);

    }

    private boolean tokenPresent(String header){
        return header != null && header.startsWith("Bearer ");
    }

    private void addUserToContext(String username){
        UserDetails user = userService.loadUserByUsername(username);
        if(user != null) {
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}
