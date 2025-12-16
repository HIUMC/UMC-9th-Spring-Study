package com.example.umcworkbook.security;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.apiPayload.code.error.GeneralErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ApiResponse<Void> errorResponse=ApiResponse.onFailure(
                GeneralErrorCode.UNAUTHORIZED,
                null
        );

        objectMapper.writeValue(response.getWriter(), errorResponse);
    }
}
