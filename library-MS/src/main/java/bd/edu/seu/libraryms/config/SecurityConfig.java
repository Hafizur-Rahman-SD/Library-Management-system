package bd.edu.seu.libraryms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()     // সব পেজ allow
                )
                .formLogin(form -> form.disable())     // login বন্ধ
                .logout(logout -> logout.disable());   // logout বন্ধ


        return http.build();
    }
}
