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
				.jdbcAuthentication().usersByUsernameQuery("select userName, password from student_tracker_user where username = ?")
				.authoritiesByUsernameQuery("select u1.userName, u2.rolCode from student_tracker_user u1, student_tracker_roles u2 where u1.id = u2.studentTrackerUserId and u1.userName =?");
	}

}
