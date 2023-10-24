package br.com.fiap.agendado.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.config.Customizer;


@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        
        return http
            .authorizeHttpRequests( auth -> auth.anyRequest().authenticated() )
            // .formLogin(Customizer.withDefaults())
            .formLogin( form -> form.loginPage("/login").defaultSuccessUrl("/agendamentos").permitAll())
            .logout( logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login") )
            .build();
    }

    
    
}
