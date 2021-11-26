package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	/*  /myAccount - Secured /myBalance Secured -  /contact - Not Secured	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/myAccount").authenticated()
				 .antMatchers("/myBalance").authenticated()
				.antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();
	}

	 //Alternative way
	/*
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("admin").password("12345").authorities
	  ("admin").and(). withUser("user").password("12345").authorities("read").and()
	  .passwordEncoder(NoOpPasswordEncoder.getInstance());
	  }
	 */

	//Alternative way
	 /* @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  InMemoryUserDetailsManager userDetailsService = new
	  InMemoryUserDetailsManager(); UserDetails user =
	  User.withUsername("admin").password("12345").authorities("admin").build();
	  UserDetails user1 =
	  User.withUsername("user").password("12345").authorities("read").build();
	  userDetailsService.createUser(user); userDetailsService.createUser(user1);
	  auth.userDetailsService(userDetailsService);
	  }
	 */
	
	//Alternative way
	 /* @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
	 * return new JdbcUserDetailsManager(dataSource); }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
