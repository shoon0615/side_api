/**
 * packageName  : com.example.side_api.config.aspect
 * fileName     : LoggerAop
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : AOP(=Aspect) log 설정 파일
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class LoggerAop {

    /**
     * Filter(Request) -> Interceptor(Before) -> AOP -> Interceptor(After) -> Filter(Response)
     * Filter: 인코딩 변환, XSS 보안 처리
     * Interceptor: 로그인 여부/권한 체크
     * AOP: 메소드 기준 -> @Before(수행 전), @After(수행 후=finally), @After-returning:(성공=success), @After-throwing:(실패=catch), @Around(수행 전/후)
     * AOP: 공통 로그 출력, 보안 처리, 예외 처리와 같은 코드를 별도로 분리해서 하나의 단위로 묶는 모듈화
     */

    // execution([return 타입] [패키지]..[메소드]) -> and(&&) 또는 or(||) 가능
    // 메소드 -> *(): 파라미터 없음, *(..): 파라미터 0개 이상, (*): 파라미터 1개, (*, *): 파라미터 2개
    // @Before("execution(* com.example.side_api.test.in.controller..*Controller.Rest*(..))")  // Like '%Controller' IN 'Rest%'
    @Around("execution(* com.example.side_api.test..*(..)) || execution(* com.example.side_api.web..*(..))")     // 전체
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {   // 반드시 Object return 해야함(void 시 intercept 후 null 처리)
        Object result = joinPoint.proceed();
        StringBuilder sb = new StringBuilder();
        String path = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String fullPath = joinPoint.getSignature().getDeclaringTypeName();
        String method = joinPoint.getSignature().getName();
        // sb.append("[loggerAop]: " + path + ": " + method);

        String type =
                StringUtils.contains(path, "Controller") ? "[Controller] ===> " :
                StringUtils.contains(path, "Service") ? "[Service] ===> " :
                StringUtils.contains(path, "Repository") ? "[Repository] ===> " :
                "";
        sb.append(type + path + ": " + method);

        Object[] args = joinPoint.getArgs();
        if(ObjectUtils.isNotEmpty(args)) {
            sb.append(" -> [loggerAop 매개변수]: ");
            for(Object o : args) {
                sb.append(String.valueOf(o) + " ");
            }
        }
        log.info(sb.toString());
        return result;
    }

    @Pointcut("@annotation(com.example.side_api.config.aspect.Timer)")   // @Timer 어노테이션 설정한 메소드
    private void enableTimer() {}                                        // pointcut 실행하면 @around 실행

    @Around("enableTimer()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 기능 작동 시간 체크
        var stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        // 기능 위치 저장
        StringBuilder sb = new StringBuilder();
        String path = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String fullPath = joinPoint.getSignature().getDeclaringTypeName();
        String method = joinPoint.getSignature().getName();
        sb.append("[Timer]: " + path + ": " + method);

        Object[] args = joinPoint.getArgs();
        if(ObjectUtils.isNotEmpty(args)) {
            sb.append(" -> [Timer 매개변수]: ");
            for(Object o : args) {
                sb.append(String.valueOf(o) + " ");
            }
        }
        log.info(sb.toString());
        log.info("[Timer 시간]: " + stopWatch.getTotalTimeMillis() + "ms");       // 1000 = 1초

        return result;
    }
}