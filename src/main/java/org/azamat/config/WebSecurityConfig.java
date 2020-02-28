package org.azamat.config;

import org.azamat.component.AuthenticationSuccessHandlerImpl;
import org.azamat.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class  WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userService;

    private final AuthenticationSuccessHandlerImpl authenticationSuccessHandler;

    @Autowired
    public WebSecurityConfig(final UserDetailsServiceImpl userService, final AuthenticationSuccessHandlerImpl authenticationSuccessHandler) {
        this.userService = userService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/registration", "/info/**", "/show/**", "/js/**", "/images/**", "/css/**").permitAll()
                    .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html#/**", "/swagger-ui.html").permitAll()
                    .antMatchers("/cart/**", "/account").hasRole("USER")
                    .antMatchers("/manage/**", "/admin/**").hasRole("ADMIN")
                    .antMatchers("/logout ").hasAnyRole("ADMIN", "USER")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .successHandler(authenticationSuccessHandler)
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(this.passwordEncoder());
    }

}
