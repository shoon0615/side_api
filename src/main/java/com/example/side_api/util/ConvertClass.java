/**
 * packageName  : com.example.side_api.util
 * fileName     : ConvertClass
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Mapper 용 Convert
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.util;

import com.example.side_api.sample.in.dto.TestRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

// @RequiredArgsConstructor
public class ConvertClass {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> Map<String, Object> convertMap(T request) {
        Map<String, Object> result = mapper.convertValue(request, new TypeReference<>() {});
        return result;
    }

    public static <T> List<Map<String, Object>> convertList(T request) {
        List<Map<String, Object>> result = mapper.convertValue(request, new TypeReference<>() {});
        return result;
    }

    public static <T, T2> T2 convertClass(T request, TypeReference<T2> response) {
        T2 result = mapper.convertValue(request, response);
        return result;
    }

}
