package com.example.diary.global.error;

import com.example.diary.global.error.handler.DiaryException;
import com.example.diary.global.error.handler.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            filterChain.doFilter(request, response);
        } catch (DiaryException e) {
            ErrorCode errorCode = e.getErrorCode();
            response.setStatus(errorCode.getStatus());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            ErrorResponse errorResponse = new ErrorResponse(errorCode.getStatus(), errorCode.getMessage());

            objectMapper.writeValue(response.getWriter(), errorResponse);
        }
    }

}