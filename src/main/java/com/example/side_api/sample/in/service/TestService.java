/**
 * packageName  : com.example.side_api.sample.in.service
 * fileName     : TestService
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Test Interface
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.sample.in.service;

import com.example.side_api.sample.in.dto.TestRequest;
import com.example.side_api.sample.out.dto.TestResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TestService {

    /**
     * method       : findAllTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 7:14
     * description  : Test 조회(request 의 id 가 null 일 경우 전체 select, 아닐 경우 단건 select)
     *
     * @param request
     * @return TestResponse & List<TestResponse>
     */
    // 하나씩은 가능하나 모두 적으면 TestResponse 만 적용되어 주석 처리
    // <T extends TestResponse & List<TestResponse>> T selectTest(TestRequest request) throws Exception;
    <T> T selectTest(TestRequest request) throws Exception;

    /**
     * method       : saveTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 8:18
     * description  : Test 저장(request 의 id 가 null 일 경우 insert, 아닐 경우 update)
     *
     * @param request
     */
    void saveTest(TestRequest request) throws Exception;

    /**
     * method       : deleteTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 8:20
     * description  : Test 삭제(id 가 null 일 경우 단건 delete, 아닐 경우 전체 delete)
     *
     * @param id
     */
    void deleteTest(Long id) throws Exception;
}
