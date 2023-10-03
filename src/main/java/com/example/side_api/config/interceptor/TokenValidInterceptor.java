/**
 * packageName  : com.example.side_api.config.interceptor
 * fileName     : TokenValidInterceptor
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Interceptor
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
// @Component
public class TokenValidInterceptor implements HandlerInterceptor {

    // 컨트롤러 접근 전 실행
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("==================== BEGIN ====================");
        log.info("Request URI ===> " + request.getRequestURI());
        return true;
    }

    // 화면(View)에 전달하기 전 실행
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("==================== END ====================");
    }
}
