package com.norulesweb.studenttracker.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {


//	@Autowired
//	StudentTrackerUserDetailsService userDetailsService;
//
//	/**
//	 * The authentication provider.
//	 */
//	@Bean
//	public DaoAuthenticationProvider daoAuthenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
//
//	/**
//	 * The authentication manager
//	 */
//	@Bean(name="localAuthenticationManager")
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

	/**
	 * HTTP security configuration
	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests()
//				.antMatchers("/user/**").permitAll()
//
//				// By default any request must be authenticated
//				// .anyRequest()
//				// .authenticated()
//
//				// Anybody can access the login page
//				.and().formLogin()
//				.loginPage("/login.html").permitAll()
//
//				// Anybody can log out of the system
//				.and().logout()
//				.permitAll()
//
//				// Allow HTTP Basic Auth
//				.and().httpBasic();
//
//		// FIXME: 2/8/2016 CSRF should probably be enabled for web security
//		http.csrf().disable();
//	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(daoAuthenticationProvider());
//	}


}
