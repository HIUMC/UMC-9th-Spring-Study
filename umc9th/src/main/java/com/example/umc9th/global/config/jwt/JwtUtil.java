package com.example.umc9th.global.config.jwt;

import com.example.umc9th.global.config.security.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * JWT 토큰을 생성, 검증하고 관련 정보를 추출하는 유틸리티 클래스
 */
@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final Duration accessExpiration;

    public JwtUtil(
            @Value("${jwt.token.secretKey}") String secret,
            @Value("${jwt.token.expiration.access}") Long accessExpiration
    ) {
        // application.yml에서 읽어온 secretKey를 기반으로 SecretKey 객체 생성
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        // application.yml에서 읽어온 만료 시간(ms)을 Duration 객체로 변환
        this.accessExpiration = Duration.ofMillis(accessExpiration);
    }

    /**
     * AccessToken을 생성합니다.
     * @param memberId 토큰에 담을 사용자의 ID
     * @return 생성된 AccessToken 문자열
     */
    public String createAccessToken(CustomUserDetails memberId) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(String.valueOf(memberId)) // 토큰의 주체로 사용자 ID를 설정
                .setIssuedAt(Date.from(now)) // 토큰 발급 시간
                .setExpiration(Date.from(now.plus(accessExpiration))) // 토큰 만료 시간
                .signWith(secretKey) // 서명에 사용할 비밀키
                .compact(); // 토큰 생성
    }

    /**
     * 토큰에서 사용자 ID(subject)를 추출합니다.
     * @param token 정보를 추출할 토큰
     * @return 사용자 ID
     */
    public Long getMemberId(String token) {
        return Long.valueOf(getClaims(token).getPayload().getSubject());
    }

    /**
     * 토큰의 유효성을 검증합니다.
     * @param token 검증할 토큰
     * @return 토큰이 유효하면 true, 아니면 false
     */
    public boolean isValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            // 토큰 파싱 중 예외 발생 시 (만료, 서명 불일치 등) 유효하지 않은 토큰으로 간주
            return false;
        }
    }

    /**
     * 토큰에서 이메일(username)을 가져옵니다.
     * @param token 유저 정보를 추출할 토큰
     * @return 유저 이메일
     */
    public String getEmail(String token) {
        try {
            // getClaims를 통해 토큰을 파싱하고, payload에서 subject(이메일)를 반환합니다.
            return getClaims(token).getPayload().getSubject();
        } catch (JwtException e) {
            // 파싱 중 예외 발생 시 null 반환
            return null;
        }
    }

    /**
     * 토큰의 서명을 검증하고 클레임(토큰에 담긴 정보)을 파싱합니다.
     * @param token 파싱할 토큰
     * @return 파싱된 클레임 정보
     */
    private Jws<Claims> getClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey) // 서명 검증에 사용할 키
                .build()
                .parseSignedClaims(token);
    }
}