/**
 * packageName  : com.example.side_api.sample.in.serviceImpl
 * fileName     : TestServiceImpl
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Test Service
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.sample.in.serviceImpl;

import com.example.side_api.sample.in.dto.TestRequest;
import com.example.side_api.sample.in.service.TestService;
import com.example.side_api.sample.out.dto.TestResponse;
import com.example.side_api.sample.out.mapper.TestMapper;
import com.example.side_api.util.ConvertClass;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestMapper testMapper;

    @Override
    public <T> T selectTest(TestRequest request) throws Exception {
        Map<String, Object> inMap = ConvertClass.convertMap(request);
        List<Map<String, Object>> entity = testMapper.selectTest(inMap);
        if(request.getId() != null) {
            Map<String, Object> outMap = entity.stream().findFirst().orElseThrow(() -> new Exception("조회된 데이터가 없습니다."));
            return (T) ConvertClass.convertClass(outMap, new TypeReference<TestResponse>(){});
        }
        return (T) ConvertClass.convertClass(entity, new TypeReference<List<TestResponse>>(){});
    }

    @Override
    public void saveTest(TestRequest request) throws Exception {
        Map<String, Object> inMap = ConvertClass.convertMap(request);
        /**
         * 하기 3개 방식은 모두 같은 내용(삼항연산자 / if문 / Optional) -> 단순값 출력은 굳이 Optional 필요없다고 함(가독성도 구림..)
         * NULL 로 인한 중첩 로직 발생 또는 NULL 로 인한 메소드나 Exception 호출 시 주 사용 목적
         */
        // int result = request.getId() != null ? testMapper.insertTest(inMap) : testMapper.updateTest(inMap);
        /*int result;         // default: 0
        if(request.getId() != null) {
            result = testMapper.insertTest(inMap);
        } else {
            result = testMapper.updateTest(inMap);
        }*/
        /** Optional 객체가 null 또는 중간 Stream 에서 null 이 발생하면 바로 마지막 orElse 로 이동 */
        int result = Optional.ofNullable(request.getId())           // of: null 비허용, ofNullable: null 허용
                .map(id -> testMapper.updateTest(inMap))            // request.getId() 가 null 이면 map 이 아닌 orElse 로 이동
                .orElseGet(() -> testMapper.insertTest(inMap));     // orElseGet: null 에만 실행, orElse: null 여부와 상관없이 실행
        /** ifPresentOrElse 는 return 없이 메소드 실행만 가능 */
        /*int result = Optional.ofNullable(request.getId())
                .ifPresentOrElse(                                   // isPresent: null 여부만 판단(return boolean)
                        data -> testMapper.updateTest(inMap),       // ifPresent: null 이 아닌 경우만 실행(return void)
                        () -> testMapper.updateTest(inMap)          // ifPresentOrElse: null 여부에 따라 실행(return void)
                );*/

        if(result == 0) {
            throw new Exception("저장된 데이터가 없습니다.");
        }
    }

    @Override
    public void deleteTest(Long id) throws Exception {
        int result;         // default: 0
        if(id != null) {
            result = testMapper.deleteTest(id);
        } else {
            result = testMapper.deleteAllTest();
        }

        if(result == 0) {
            throw new Exception("삭제된 데이터가 없습니다.");
        }
    }

}
