package com.telemetryx.api.security;

import com.telemetryx.api.service.JWTService;
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
public class JWT_Filter extends OncePerRequestFilter
{
    private final CustomUserDetailsService customUserDetailsService;
    private final JWTService jwtService;

    public JWT_Filter(CustomUserDetailsService customUserDetailsService, JWTService jwtService)
    {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        String authheader = request.getHeader("Authorization");

        String jwt = null;
        String username = null;

        if(authheader != null && authheader.startsWith("Bearer "))
        {
            try
            {
                jwt = authheader.substring(7);

                username = JWTService.extractUsername(jwt);

                if (username != null)
                {
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

                    if (jwtService.isTokenValid(jwt, userDetails.getUsername()))
                    {
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                        SecurityContextHolder.getContext().setAuthentication(authToken);

                    }
                }
            } catch (Exception e)
            {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid or expired JWT");
                return;
            }
        }
        filterChain.doFilter(request , response);
    }


}
