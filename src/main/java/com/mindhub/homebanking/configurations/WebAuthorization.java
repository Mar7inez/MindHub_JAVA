package com.mindhub.homebanking.configurations;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@EnableWebSecurity
@Configuration
public class WebAuthorization {
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/clients").permitAll()
                .antMatchers("/web/login.html","/web/css/**","/web/index.html","/web/js/**","/web/ccs/style.css","/web/js/index.js","/web/img/**","/web/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/clients/current", "/api/accounts/","/api/loans","/api/clients/current/accounts","/api/clients/current", "/api/accounts/*","/api/cards/current", "/api/transactions","/api/clients/current/cards").hasAnyAuthority("CLIENT","ADMIN")
                .antMatchers(HttpMethod.POST,"/api/clients/current/cards","/api/clients/current/accounts","/api/clients/current/transactions","/api/transactions","/api/loans").hasAnyAuthority("CLIENT","ADMIN")
                .antMatchers("/h2-console/", "/rest/","/api/clients").hasAuthority("ADMIN")
                //.antMatchers("/web/").hasAnyAuthority("ADMIN","CLIENT")

                .anyRequest().denyAll();

        http.formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginPage("/api/login");

        http.logout().logoutUrl("/api/logout").deleteCookies("JSESSIONID");

        http.csrf().disable();

        http.headers().frameOptions().disable();

        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());

        return http.build();
    }
    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }


    }

}