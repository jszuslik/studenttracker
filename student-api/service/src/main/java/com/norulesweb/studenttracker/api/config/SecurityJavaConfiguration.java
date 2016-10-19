package com.norulesweb.studenttracker.api.config;

import com.norulesweb.studenttracker.api.security.AuthSuccessHandler;
import com.norulesweb.studenttracker.api.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private AuthSuccessHandler authSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().
				withUser("temporary").password("temporary").roles("ADMIN").and().
				withUser("user").password("userPass").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint)
				.and()
				.authorizeRequests()
				.antMatchers("/service/user/login").authenticated()
				.and()
				.formLogin()
				.successHandler(authSuccessHandler)
				.failureHandler(new SimpleUrlAuthenticationFailureHandler())
				.and()
				.logout();
	}

	@Bean
	public AuthSuccessHandler mySuccessHandler(){
		return new AuthSuccessHandler();
	}
	@Bean
	public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
		return new SimpleUrlAuthenticationFailureHandler();
	}
}
