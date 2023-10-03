/**
 * packageName  : com.example.side_api.config.aspect
 * fileName     : Timer
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : [커스텀 어노테이션] 메소드 실행 시간 체크
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.config.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Timer {       // 커스텀 어노테이션
}
