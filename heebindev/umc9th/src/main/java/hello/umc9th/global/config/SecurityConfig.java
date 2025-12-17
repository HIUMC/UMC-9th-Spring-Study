package hello.umc9th.global.config;

//보안 정책을 정의하는 클래스.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //Spring security 활성화 <- 기본 설정보다 이 클래스의 보안 설정이 우선순위가 됨.
@Configuration
public class SecurityConfig {

    private final String[] allowUris = { //허용할 URI를 따로 빼서 관리.
			    // Swagger 허용
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v3/api-docs/**",
            "/users/**" //이거 추가
    };

    @Bean //SecurityFileterChain을 정의.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //CSRF 비활성화
                //Http 요청에 대한 접근 제어 설정
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(allowUris).permitAll() //로그인없이 누구나 접근 가능한 경로
                        .requestMatchers("/admin/**").hasRole("ADMIN") //ADMIN 역할을 가진 사용자만 접근 가능
                        .anyRequest().authenticated() //그 외 모든 요청에 대해 인증을 요구
                )
                //폼 기반 로그인에 대한 설정
                .formLogin(form -> form
                        .defaultSuccessUrl("/swagger-ui/index.html", true)
                        .permitAll()
                        // 로그인 성공 시 해당 html로 리다이렉트, 로그인 페이지는 모두가 접근 가능
                )
                //로그아웃 처리에 대한 설정
                .logout(logout -> logout
                        .logoutUrl("/logout") // "/logout"경로로 로그아웃을 처리.
                        .logoutSuccessUrl("/login?logout") //로그아웃 성공시 /login?logout으로 리다이렉트
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //단방향 해시 함수
    }
}