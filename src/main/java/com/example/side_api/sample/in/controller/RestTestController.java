/**
 * packageName  : com.example.side_api.sample.in.controller
 * fileName     : RestTestController
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Test Controller
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.sample.in.controller;

import com.example.side_api.sample.in.dto.TestRequest;
import com.example.side_api.sample.in.service.TestService;
import com.example.side_api.sample.out.dto.TestResponse;
import com.example.side_api.sample.out.entity.TestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor                    // 초기화 되지않은 final 필드나 @NonNull 이 붙은 필드에 대해 생성자를 생성
@RequestMapping("/api/v1/sample")
public class RestTestController {

    // @Autowired                           // @RequiredArgsConstructor 로 인해 자동으로 연결
    private final TestService testService;

    /**
     * method       : findTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 7:05
     * description  : Test 상세정보 조회
     *
     * @param id
     * @return ResponseEntity
     */
    // @Timer                               // 커스텀 어노테이션 예시
    @GetMapping("/{id}")
    /*@Operation(summary = "상세정보 조회", description = "상세정보를 조회한다.",      // 테스트 에선 번잡하기 때문에 swagger 생략
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = TestResponse.class))),
                    // @ApiResponse(responseCode = "200", description = "성공", content = @Content(array = @ArraySchema(schema = @Schema(implementation = TestResponse.class)))),
                    @ApiResponse(responseCode = "400", description = "실패", content = @Content(schema = @Schema(implementation = TestResponse.class))),
                    @ApiResponse(responseCode = "404", description = "못찾음", content = @Content(schema = @Schema(implementation = TestResponse.class)))
            })*/
    public ResponseEntity findTest(@PathVariable final Long id) throws Exception {
        TestRequest request = TestRequest.builder().id(id).build();
        return ResponseEntity.ok(testService.selectTest(request));
    }

    /**
     * method       : findAllTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 7:05
     * description  : Test 목록 조회
     *
     * @param request
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity findAllTest(final TestRequest request) throws Exception {
        return ResponseEntity.ok(testService.selectTest(request));
    }

    /**
     * method       : insertTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 7:05
     * description  : Test 입력
     *
     * @param request
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity insertTest(@RequestBody final TestRequest request) throws Exception {
        testService.saveTest(request);
        return ResponseEntity.ok(null);

    }

    /**
     * method       : saveTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 7:07
     * description  : Test 저장(save: 저장, update: 수정)
     *
     * @param request
     * @return ResponseEntity
     */
    @PutMapping
    public ResponseEntity saveTest(@RequestBody final TestRequest request) throws Exception {
        testService.saveTest(request);
        return ResponseEntity.ok(null);
    }

    /**
     * method       : deleteTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 7:08
     * description  : Test 삭제
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTest(final Long id) throws Exception {
        testService.deleteTest(id);
        return ResponseEntity.ok(null);
    }

    /**
     * method       : deleteAllTest
     * author       : SangHoon
     * date         : 2023-10-03 오후 7:08
     * description  : Test 전체 삭제
     *
     * @return ResponseEntity
     */
    @DeleteMapping
    public ResponseEntity deleteAllTest() throws Exception {
        testService.deleteTest(null);
        return ResponseEntity.ok(null);
    }

}
