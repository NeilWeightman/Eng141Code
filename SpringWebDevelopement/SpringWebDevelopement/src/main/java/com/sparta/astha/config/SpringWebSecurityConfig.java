package com.sparta.astha.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SpringWebSecurityConfig {
    @Bean
    // create the user registry in memory
    public InMemoryUserDetailsManager configureUsers() throws Exception {
        UserDetails omari = User.withDefaultPasswordEncoder()
                .username("Omari")
                .password("secret123")
                .roles("ADMIN")
                .build();
        UserDetails jb = User.withDefaultPasswordEncoder()
                .username("JB")
                .password("passw0rd")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(omari, jb);
    }

    @Bean
    // set up the security policy - authorisation
    public SecurityFilterChain configurePolicy(HttpSecurity http) throws Exception {
        return http.authorizeRequests(auth -> {
                    auth.requestMatchers("/sakila/cast/add/**")
                        .hasRole("ADMIN");
                    auth.requestMatchers("/sakila/actor/all")
                        .permitAll();
                })
                .formLogin()
                .loginPage("/sakila/login")
                .loginProcessingUrl("/login")
                .successForwardUrl("/sakila/actor/all")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .and()
                //.httpBasic(Customizer.withDefaults())
                .build();
    }
}
