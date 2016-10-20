package com.norulesweb.studenttracker.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebSecurity
public class StatelessCsrfSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.addFilterAfter(new StatelessCsrfFilter(), CsrfFilter.class)
				.authorizeRequests()
					.antMatchers("/user/**").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("bob").password("bob123").authorities("ROLE_USER").and()
				.withUser("admin").password("admin123").authorities("ROLE_USER", "ROLE_ADMIN");
	}

}
