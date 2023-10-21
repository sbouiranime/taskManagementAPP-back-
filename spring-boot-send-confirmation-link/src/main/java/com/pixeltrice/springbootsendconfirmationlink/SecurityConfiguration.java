package com.pixeltrice.springbootsendconfirmationlink;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @SuppressWarnings({ "deprecation", "removal" })
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers(request -> request.getContextPath().startsWith("/register")).permitAll()
                .requestMatchers("/confirm").permitAll()
                .anyRequest().authenticated()
                .and()
            .csrf().disable(); // Disable CSRF protection
    }
}
