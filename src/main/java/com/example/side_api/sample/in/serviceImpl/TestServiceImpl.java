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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // int result = request.getId() != null ? testMapper.insertTest(inMap) : testMapper.updateTest(inMap);
        int result;         // default: 0
        if(request.getId() != null) {
            result = testMapper.insertTest(inMap);
        } else {
            result = testMapper.updateTest(inMap);
        }

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
