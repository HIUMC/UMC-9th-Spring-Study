//package com.example.umc9th.global.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity // (1) Spring Security를 활성화하고 웹 보안 설정을 구성함을 알립니다.
//@Configuration // (2) 이 클래스가 Spring의 설정 클래스임을 나타냅니다.
//public class SecurityConfig {
//
//    // (3) 인증/인가 없이 접근을 허용할 URI 목록을 정의합니다.
//    private final String[] allowUris = {
//            "/member/sign-up", // 회원가입, 로그인 등 member 관련 API 허용
//            "/member/login" ,   // 로그인
//            "/swagger-ui/**",
//            "/swagger-resources/**",
//            "/v3/api-docs/**",
//    };
//
//    @Bean // (4) 이 메서드가 반환하는 객체를 Spring 컨테이너가 관리하는 Bean으로 등록합니다.
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // (5) HttpSecurity 객체를 사용하여 세부적인 보안 설정을 구성합니다.
//        http
//                // (1) CSRF(Cross-Site Request Forgery) 보호 비활성화
//                .csrf(AbstractHttpConfigurer::disable)
//
//                // (6) HTTP 요청에 대한 인가(Authorization) 규칙을 설정합니다.
//                .authorizeHttpRequests(requests -> requests
//                        // (7) allowUris에 정의된 경로들은 누구나 접근할 수 있도록 허용합니다.
//                        .requestMatchers(allowUris).permitAll()
//                        // (8) "/admin/**" 패턴의 경로는 "ADMIN" 역할을 가진 사용자만 접근할 수 있도록 제한합니다.
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        // (9) 위에서 설정한 경로 외의 모든 요청은 반드시 인증(로그인)을 거쳐야 합니다.
//                        .anyRequest().authenticated()
//                )
//                // (10) 폼 기반 로그인을 설정합니다.
//                .formLogin(form -> form
//                        // (11) 로그인 성공 시 리다이렉트될 기본 URL을 설정합니다.
//                        // 사용자가 특정 페이지를 보려다 로그인했다면, 원래 보려던 페이지로 이동합니다.
//                        // 직접 로그인 페이지로 와서 성공하면 아래 URL로 갑니다.
//                        .defaultSuccessUrl("/swagger-ui/index.html", true)
//                        // (12) 로그인 페이지는 누구나 접근할 수 있도록 허용합니다.
//                        .permitAll()
//                )
//                // (13) 로그아웃 기능을 설정합니다.
//                .logout(logout -> logout
//                        // (14) 로그아웃을 처리할 URL을 지정합니다.
//                        .logoutUrl("/logout")
//                        // (15) 로그아웃 성공 시 리다이렉트될 URL을 지정합니다.
//                        .logoutSuccessUrl("/login?logout")
//                        // (16) 로그아웃 관련 페이지는 누구나 접근할 수 있도록 허용합니다.
//                        .permitAll()
//                );
//
//        // (17) 설정이 완료된 HttpSecurity 객체를 기반으로 SecurityFilterChain을 생성하여 반환합니다.
//        return http.build();
//    }
//
//    /**
//     * (5) 비밀번호 암호화를 위한 PasswordEncoder 빈 등록
//     * @return BCryptPasswordEncoder 인스턴스
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

package com.example.umc9th.global.config;

//import com.example.umc9th.config.jwt.JwtAuthFilter;
//import com.example.umc9th.config.jwt.JwtUtil;
import com.example.umc9th.global.config.jwt.JwtAuthFilter;
import com.example.umc9th.global.config.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 설정을 담당하는 클래스입니다.
 * JWT 기반의 토큰 인증을 사용하도록 설정합니다.
 *
 * @author shinwook.kang
 */
@Configuration
@EnableWebSecurity // (1) Spring Security를 활성화하고 웹 보안 설정을 구성함을 알립니다.
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtUtil jwtUtil;
    private final com.example.umc9th.global.config.security.CustomUserDetailsService customUserDetailsService;

    // (2) 인증/인가 없이 접근을 허용할 URI 목록을 정의합니다.
    private final String[] allowUris = {
            "/",                // 루트 경로
            "/swagger-ui/**",   // Swagger UI
            "/v3/api-docs/**",  // Swagger API 문서
            "/member/sign-up",  // 회원가입 API
            "/member/login"     // 로그인 API
    };

    @Bean // (3) 이 메서드가 반환하는 객체를 Spring 컨테이너가 관리하는 Bean으로 등록합니다.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // (4) HttpSecurity 객체를 사용하여 세부적인 보안 설정을 구성합니다.
        http
                // (5) CSRF(Cross-Site Request Forgery) 보호 비활성화.
                // 토큰 기반 인증에서는 세션을 사용하지 않으므로 CSRF 공격에 비교적 안전합니다.
                .csrf(AbstractHttpConfigurer::disable)

                // (6) 세션 관리 정책을 STATELESS로 설정합니다.
                // 서버가 클라이언트의 상태를 저장하지 않는 '상태 비저장' 방식으로, 모든 요청은 토큰을 통해 인증됩니다.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // (7) HTTP 요청에 대한 인가(Authorization) 규칙을 설정합니다.
                .authorizeHttpRequests(requests -> requests
                        // (8) allowUris에 정의된 경로들은 누구나 접근할 수 있도록 허용합니다.
                        .requestMatchers(allowUris).permitAll()
                        // (9) 그 외의 모든 요청은 반드시 인증(유효한 토큰 소지)을 거쳐야 합니다.
                        .anyRequest().authenticated()
                )

                // (10) Spring Security가 기본 제공하는 폼 로그인과 HTTP Basic 인증을 비활성화합니다.
                // 우리는 커스텀 필터인 JwtAuthFilter를 통해 인증을 처리할 것이기 때문입니다.
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)

                // (11) 우리가 직접 만든 JwtAuthFilter를 Spring Security의 필터 체인에 추가합니다.
                // UsernamePasswordAuthenticationFilter(로그인 처리 필터)보다 먼저 실행되도록 설정합니다.
                .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);

        // (12) 설정이 완료된 HttpSecurity 객체를 기반으로 SecurityFilterChain을 생성하여 반환합니다.
        return http.build();
    }

    /**
     * (13) 우리가 만든 JwtAuthFilter를 Bean으로 등록합니다.
     * 이 필터는 JwtUtil과 CustomUserDetailsService를 필요로 합니다.
     * @return JwtAuthFilter 인스턴스
     */
    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return new JwtAuthFilter(jwtUtil, customUserDetailsService);
    }

    /**
     * (14) 비밀번호 암호화를 위한 PasswordEncoder를 Bean으로 등록합니다.
     * BCrypt 알고리즘을 사용하는 BCryptPasswordEncoder를 사용합니다.
     * @return BCryptPasswordEncoder 인스턴스
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}