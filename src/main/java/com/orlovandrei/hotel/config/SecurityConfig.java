package com.orlovandrei.hotel.config;

import com.orlovandrei.hotel.service.UserService;
import com.orlovandrei.hotel.security.filter.JwtFilter;
import com.orlovandrei.hotel.security.handler.CustomAccessDeniedHandler;
import com.orlovandrei.hotel.security.handler.CustomLogoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor(onConstructor_ = @__(@Lazy))
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final UserService userService;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomLogoutHandler customLogoutHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers("/api/v1/auth/login", "/api/v1/auth/registration",
                                    "/api/v1/auth/refresh_token",
                                    "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html")
                            .permitAll()
                            .requestMatchers("GET", "/api/v1/rooms", "/api/v1/rooms/{id}")
                            .permitAll()

                            // User endpoints
                            .requestMatchers("GET", "/api/v1/users/{id}").hasAnyAuthority("USER", "ADMIN")
                            .requestMatchers("GET", "/api/v1/bookings", "/api/v1/bookings/{id}").hasAnyAuthority("USER", "ADMIN")
                            .requestMatchers("POST", "/api/v1/bookings").hasAnyAuthority("USER", "ADMIN")
                            .requestMatchers("DELETE", "/api/v1/bookings/{id}").hasAnyAuthority("USER", "ADMIN")
                            .requestMatchers("GET", "/api/v1/maintenances").hasAnyAuthority("USER", "ADMIN")
                            .requestMatchers("POST", "/api/v1/reviews").hasAnyAuthority("USER", "ADMIN")

                            // Admin endpoints
                            .requestMatchers(
                                    "/api/v1/users/**",
                                    "/api/v1/employees/**",
                                    "/api/v1/inventories/**",
                                    "/api/v1/maintenances/**",
                                    "/api/v1/reviews/**"
                            ).hasAuthority("ADMIN")
                            .requestMatchers("POST", "/api/v1/rooms", "/api/v1/rooms/**").hasAuthority("ADMIN")
                            .requestMatchers("PUT", "/api/v1/rooms/**").hasAuthority("ADMIN")
                            .requestMatchers("DELETE", "/api/v1/rooms/**").hasAuthority("ADMIN")
                            .anyRequest().authenticated();
                })
                .userDetailsService(userService)
                .exceptionHandling(e -> {
                    e.accessDeniedHandler(accessDeniedHandler)
                            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
                })
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(log -> {
                    log.logoutUrl("/logout")
                            .addLogoutHandler(customLogoutHandler)
                            .logoutSuccessHandler((request, response, authentication) ->
                                    SecurityContextHolder.clearContext());
                });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}