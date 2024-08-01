package ru.shendo.flashcards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.shendo.flashcards.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login", "/register", "/public/**", "/css/**", "/js/**").permitAll() // Доступ без аутентификации
                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Ваша кастомная страница логина
                        .defaultSuccessUrl("/swagger-ui/index.html", true) // Перенаправление на Swagger UI после успешной авторизации
                        .failureUrl("/login?error=true") // Перенаправление на страницу логина с параметром error
                        .permitAll()
                )
                .logout((logout) -> logout
                        .permitAll()
                );
        return http.build();
    }
}