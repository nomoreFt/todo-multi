package com.nomoreft.todoapp.web.servlet;

import com.nomoreft.todoapp.foundation.exception.NotImplementedException;
import com.nomoreft.todoapp.support.PermitWithoutJWTToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 현재 요청의 핸들러 메서드 가져오기
        Object handler = request.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            // 애노테이션 확인: 클래스나 메서드에 @PermitWithoutToken 적용 여부 검사
            if (handlerMethod.hasMethodAnnotation(PermitWithoutJWTToken.class) ||
                    handlerMethod.getBeanType().isAnnotationPresent(PermitWithoutJWTToken.class)) {
                // JWT 검증을 건너뛴다
                filterChain.doFilter(request, response);
                return;
            }
        }

        //todo: JWT 검증 로직 추가
        throw new NotImplementedException();
        /**
         *         try {
         *             extractJwtFromRequest(request)
         *                     .ifPresent(jwt -> authenticateUser(jwt, request));
         *         } catch (AccessTokenExpiredExceptions | RefreshTokenExpiredExceptions e) {
         *             handleException(response, e);
         *             return;
         *         }
         *
         *         filterChain.doFilter(request, response);
         */
        //filterChain.doFilter(request, response);
    }
}