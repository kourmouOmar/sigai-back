package com.softfactory.sigai.config;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final long JWT_TOKEN_VALIDITY = 20 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

	/*
	 * get username from jwt token
	 **/
	public String getUsernameFromToken(String token) {

		return getClaimFromToken(token, Claims::getSubject);

	}

	/*
	 * retrieve expiration date from jwt token
	 **/
	public Date getExpirationDateFromToken(String token) {

		return getClaimFromToken(token, Claims::getExpiration);

	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = getAllClaimsFromToken(token);

		return claimsResolver.apply(claims);
	}

	/*
	 * for retrieveing any information from token we will need the secret key
	 */
	private Claims getAllClaimsFromToken(String token) {
		String encodedString = Base64.getEncoder().encodeToString(secret.getBytes());
		return Jwts.parser().setSigningKey(encodedString).parseClaimsJws(token).getBody();
	}

	/*
	 * check if the token has expired
	 */
	private Boolean isTokenExpired(String token) {

		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/*
	 * generate token for user
	 */
	public String generateToken(UserDetails userDetails) {

		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {

		String encodedString = Base64.getEncoder().encodeToString(secret.getBytes());

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(SignatureAlgorithm.HS512, encodedString).compact();
	}

	/*
	 * validate token
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
