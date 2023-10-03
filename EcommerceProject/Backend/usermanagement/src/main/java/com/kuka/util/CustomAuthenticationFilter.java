package com.kuka.util;

import com.kuka.exceptions.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private TokenUtil tokenUtil;

    private UserDetailsService userService;

   // @Autowired
   //  private AuthenticationProvider authProvider;

    @Autowired
    public CustomAuthenticationFilter(UserDetailsService service, TokenUtil tokenUtil) {
        this.userService = service;
        this.tokenUtil = tokenUtil;
    }
    /**
     * Custom authentication filter that intercepts incoming HTTP requests and performs token-based authentication.
     *
     * @param request The incoming HttpServletRequest.
     * @param response The HttpServletResponse.
     * @param filterChain The filter chain to continue processing the request.
     * @throws ServletException If a servlet-related error occurs during processing.
     * @throws IOException If an I/O error occurs during processing.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Extract the token from the "Authorization" header of the HTTP request.
        String token = request.getHeader("Authorization");
        System.out.println("fetched token=" + token);
        try {
            String uri = request.getRequestURI();
            System.out.println(uri);
            System.out.println("request parameter=" + request.getParameter("username") + " uri=" + uri + " method=" + request.getMethod());
            // Allow unauthenticated access to login and registration endpoints.
            if (uri.startsWith("/users/user/login") || uri.startsWith("/users/user/registeration")||uri.startsWith("/v3/api-docs")||uri.startsWith("/swagger-ui")||uri.startsWith("/swagger-ui/index.html")){
                filterChain.doFilter(request, response);
                return;
            }
            // Ensure that the token is not null or empty.
            if (token == null || token.isEmpty()) {
                throw new InvalidTokenException("invalid token, can't be null or empty");
            }
            // Remove the "Bearer " prefix from the token.
            token = token.substring(7);

            String username = tokenUtil.decode(token);
            // Load user details based on the decoded username.
            UserDetails user = userService.loadUserByUsername(username);
            System.out.println("user details fetched from token=" + user.getUsername() + "," + user.getPassword() + "-" + user.getAuthorities());
            UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(username, user.getPassword(), user.getAuthorities());
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(newAuthentication);
            filterChain.doFilter(request, response);

        } catch (UsernameNotFoundException | InvalidTokenException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("You are not authorized");
        }

    }
}
