package com.task.assignment.Jwt;

import com.task.assignment.Services.SecurityServices.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Service("jwtAuthentication")
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private JwtProvider jwtProvider ;
    private UserService userService ;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String jwt =  getJwtFormRequest(request) ;
            if(StringUtils.hasText(jwt)&& jwtProvider.validateToken(jwt)) {
                UserDetails userDetails =  userService.loadUserById(jwtProvider.getUserIdFromJwt(jwt)) ;
                if(userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        catch (Exception e) {
            log.error("failed on set user authentication",e);
        }
        filterChain.doFilter(request, response);
    }
    public String getJwtFormRequest(HttpServletRequest request) {
        String bearerToken =  request.getHeader("Authorization") ;
        if(StringUtils.hasText( bearerToken) && bearerToken.startsWith("Bearer ") ) {
            return bearerToken.substring(7) ;
        }
        return null ;
    }

    @Autowired
    public void setJwtProvider(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

