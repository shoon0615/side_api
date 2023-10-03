/**
 * packageName  : com.example.side_api.sample.out.mapper
 * fileName     : TestMapper
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Test Mapper
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.sample.out.mapper;

import com.example.side_api.sample.in.dto.TestRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {
    List<Map<String, Object>> selectTest(Map<String, Object> inMap);
    int insertTest(Map<String, Object> inMap);
    int updateTest(Map<String, Object> inMap);
    int deleteTest(Long id);
    int deleteAllTest();
}
