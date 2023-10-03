/**
 * packageName  : com.example.side_api.sample.in.dto
 * fileName     : TestRequest
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Test InDto
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.sample.in.dto;

import lombok.*;

// @Data                                                // @Getter, @Setter, @ToString, @EqualsAndHashCode.. 다수 기능 함축
@Getter
// @Setter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)      // 무분별한 기본 생성자 생성 방지
@AllArgsConstructor                                     // @Builder 는 생성자 생성이 없어 전체 파라미터의 생성자 필요
public class TestRequest {

    private Long id;            // id
    private String name;        // 이름
    private Integer age;        // 나이(int 는 자료형(primitive)으로 null 허용이 안되어 원시형(Wrapper)으로 설정

    // @NoArgsConstructor(access = AccessLevel.PROTECTED)로 생성된 생성자
    // protected TestRequest() {}

    // 원래는 @AllArgsConstructor 사용을 지양하고 @Builder 유지해야하나 테스트 에선 생략
    /*@Builder
    public TestRequest(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }*/

}
