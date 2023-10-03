/**
 * packageName  : com.example.side_api.sample.out.dto
 * fileName     : TestResponse
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Test OutDto
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.sample.out.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResponse {

    private Long id;            // id
    private String name;        // 이름
    private int age;            // 나이

}
