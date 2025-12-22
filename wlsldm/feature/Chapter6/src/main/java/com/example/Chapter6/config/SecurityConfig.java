package com.example.Chapter6.config;

import com.example.Chapter6.domain.security.AuthenticationEntryPointImpl;
import com.example.Chapter6.domain.security.CustomUserDetailsService;
import com.example.Chapter6.domain.security.JwtAuthFilter;
import com.example.Chapter6.domain.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity //Spring Security 설정 활성화
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    //허용할 URL 따로 빼서 관리
    private final String[] allowUris = {
            "/sign-up",
            "/login",
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v3/api-docs/**",
    };

    //SecurityFilterChain 정의
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //HTTP요청에 대한 접근 제어 설정
                .authorizeHttpRequests(requests -> requests
                        //특정 URL 패턴에 대한 접근 권한 설정
                        .requestMatchers(allowUris).permitAll() // 인증 없이 접근 가능한 경로 지정
                        .requestMatchers("/admin/**").hasRole("ADMIN") //ADMIN 역할만 접근 가능한 결로 지정

                        //그외 모든 요청
                        .anyRequest().authenticated() //인증 요구
                )

                //폼로그인 비활성화
                .formLogin(AbstractHttpConfigurer::disable)

                // JwtAuthFilter를 UsernamePasswordAuthenticationFilter 앞에 추가
                .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
        .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint()));


        /*
                //폼 기반 로그인 설정
                .formLogin(form -> form
                        //성공시 리다이렉트할 경로 지정
                        .defaultSuccessUrl("/swagger-ui/index.html", true)
                        .permitAll() //모두 접근 가능
                )
                .csrf(AbstractHttpConfigurer::disable)

                //로그아웃 설정
                .logout(logout -> logout
                        //로그아웃 처리할 경로
                        .logoutUrl("/logout")

                        //로그아웃 성공 시 리다이렉트할 경로 지정
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        */
        return http.build();
    }

    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return new JwtAuthFilter(jwtUtil, customUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPointImpl();
    }
}
