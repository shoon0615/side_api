/**
 * packageName  : com.example.side_api.sample.out.entity
 * fileName     : TestEntity
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Test SQL Entity
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.sample.out.entity;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestEntity {

    private Long id;            // id
    private String name;        // 이름
    private int age;            // 나이

}
