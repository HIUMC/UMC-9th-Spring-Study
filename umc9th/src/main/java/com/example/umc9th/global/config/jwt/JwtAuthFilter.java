package com.example.umc9th.global.config.jwt;

//import com.example.umc9th.config.security.CustomUserDetailsService;
import com.example.umc9th.global.config.security.CustomUserDetailsService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.status.ErrorStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        try {
            // 1. 요청 헤더에서 "Authorization" 헤더를 가져옵니다.
            String token = request.getHeader("Authorization");

            // 2. 토큰이 없거나, "Bearer " 접두사로 시작하지 않으면 다음 필터로 넘어갑니다.
            if (token == null || !token.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }

            // 3. "Bearer " 접두사를 제거하여 순수한 토큰만 추출합니다.
            String accessToken = token.replace("Bearer ", "");

            // 4. JwtUtil을 사용하여 토큰의 유효성을 검증합니다.
            if (jwtUtil.isValid(accessToken)) {
                // 5. 토큰이 유효하면, 토큰에서 사용자의 이메일을 추출합니다.
                String email = jwtUtil.getEmail(accessToken);

                // 6. CustomUserDetailsService를 사용하여 DB에서 사용자 정보를 조회합니다.
                UserDetails user = customUserDetailsService.loadUserByUsername(email);

                // 7. 조회된 사용자 정보로 Authentication 객체를 생성합니다.
                //    (principal, credentials, authorities)
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        user,
                        null, // 비밀번호는 사용하지 않으므로 null
                        user.getAuthorities()
                );

                // 8. SecurityContextHolder에 생성된 Authentication 객체를 설정합니다.
                //    이제 이 요청의 처리 과정에서는 이 사용자가 인증된 것으로 간주됩니다.
                SecurityContextHolder.getContext().setAuthentication(auth);
            } else {
                // 토큰이 유효하지 않은 경우 (예: 만료)
                throw new SecurityException("Invalid or expired token");
            }

            // 9. 다음 필터 체인을 실행합니다.
            filterChain.doFilter(request, response);

        } catch (Exception e) {
            // 10. 필터 과정에서 예외 발생 시, 커스텀 에러 응답을 생성합니다.
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 상태 코드

            ApiResponse<Void> errorResponse = ApiResponse.of(ErrorStatus._UNAUTHORIZED, null);

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), errorResponse);
        }
    }
}