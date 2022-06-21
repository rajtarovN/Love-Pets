package sbnz.integracija.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import sbnz.integracija.example.exception.NotFoundException;
import sbnz.integracija.example.utils.TokenUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthenticationTokenFilter extends OncePerRequestFilter {

	 private final TokenUtils tokenUtils;
	    private final UserDetailsService userDetailsService;
	    protected final Log LOGGER = LogFactory.getLog(getClass());

	    public AuthenticationTokenFilter(TokenUtils tokenUtils, UserDetailsService userDetailsService) {
	        this.userDetailsService = userDetailsService;
	        this.tokenUtils = tokenUtils;
	    }

	    @Override
	    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	            throws IOException, ServletException {

	        String username;
	        String authToken = tokenUtils.getToken(request);

	        try {
	            if (authToken != null) {

	                // Get username from token
	                username = tokenUtils.getUsernameFromToken(authToken);

	                if (username != null) {

	                    // Get user based on username
	                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

	                    // Check if passed token is valid
	                    if (tokenUtils.validateToken(authToken, userDetails)) {

	                        // Create authentication
	                        TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
	                        authentication.setToken(authToken);
	                        SecurityContextHolder.getContext().setAuthentication(authentication);
	                    }
	                }
	            }

	        } catch (ExpiredJwtException ex) {
	            LOGGER.debug("Token expired!");
	        }

	        // Pass the request to the next filter
	        chain.doFilter(request, response);
	    }

}
