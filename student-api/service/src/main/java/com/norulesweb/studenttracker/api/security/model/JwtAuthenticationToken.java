package com.norulesweb.studenttracker.api.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * Holder for JWT token from the request.
 * <p/>
 * Other fields aren't used but necessary to comply to the contracts of AbstractUserDetailsAuthenticationProvider
 *
 * @author pascal alma
 */
@Component
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 5698741230L;

	private String token;
	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	@Override
	public Object getCredentials() {
		return null;
	}
	@Override
	public Object getPrincipal() {
		return null;
	}
}
