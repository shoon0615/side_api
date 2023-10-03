/**
 * packageName  : com.example.side_api.util
 * fileName     : CamelHashMap
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Mapper -> CamelCase 로 return 해주는 타입
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.util;

import org.springframework.jdbc.support.JdbcUtils;

import java.util.HashMap;

// @Alias("CamelHashMap")
public class CamelHashMap extends HashMap {
    private static final long serialVersionUID = 1l;

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName((String) key), value);
    }
}
