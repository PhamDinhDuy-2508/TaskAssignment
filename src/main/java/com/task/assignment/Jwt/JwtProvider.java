package com.task.assignment.Jwt;

import com.task.assignment.Configuration.Details.UserInfoDetail;
import com.task.assignment.Entity.User;
import com.task.assignment.Exception.TaskException;
import com.task.assignment.Services.TaskServices.TaskServiceImpl.TaskServiceImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("jwtProvider")
public class JwtProvider {
    Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

    public static final String JWT_SECRET = "phamdinhduy2508";
    private final long JWT_EXPIRATION = 1200000000000L;

    public String generateToken(UserInfoDetail userInfoDetail) {
        Date now = new Date();
        Map<String, Object> claims = new HashMap<>();
        Date expireDate = new Date(now.getTime() + JWT_EXPIRATION);
        User user = userInfoDetail.getUser();
        claims.put("user_name", user.getName());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(Long.toString(userInfoDetail.getUser().getId()))
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public Long getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }


    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
            throw new TaskException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
            throw new TaskException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
            throw new UnsupportedJwtException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
            throw new TaskException("JWT claims string is empty.");
        }
    }

}
