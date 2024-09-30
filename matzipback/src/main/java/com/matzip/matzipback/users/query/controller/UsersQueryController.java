package com.matzip.matzipback.users.query.controller;

import com.matzip.matzipback.users.query.dto.userInfo.AllUserInfoResponseDTO;
import com.matzip.matzipback.users.query.service.UsersInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class UsersQueryController {

    private final UsersInfoService usersInfoService;

    @GetMapping("/auth/register")
    public ResponseEntity<Map<String, String>> getSignUp() {
        log.info("회원가입 화면으로 이동");
        Map<String, String> response = new HashMap<>();
        response.put("message", "회원가입 화면으로 이동");
        response.put("url", "/register"); // 프론트엔드 회원가입 화면의 경로
        return ResponseEntity.ok(response); // JSON 응답
    }

//    @GetMapping("/auth/login")
//    public String getLogin(){
//
//        return "";
//    }

    @GetMapping("/users/list")
    public ResponseEntity<AllUserInfoResponseDTO> getAllUserList(@RequestParam(value = "socialYn", required = false) String socialYn,
                                                                 @RequestParam(value = "businessVerifiedYn", required = false) String businessVerifiedYn,
                                                                 @RequestParam(value = "influencerYn", required = false) String influencerYn,
                                                                 @RequestParam(value = "orderBy", defaultValue = "regDateDesc") String orderBy,
                                                                 @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
                                                                //defaultValue : 기본값 설정, required = false : 파라미터 선택적(필수아님)
        log.info("GET /api/v1/users/list - 전체 회원 정보 조회 요청");
        AllUserInfoResponseDTO users = usersInfoService.getAllUserList(socialYn, businessVerifiedYn, influencerYn, orderBy, page, size);
        log.info("전체 회원 정보 조회 완료. 현재 페이지: {}, 전체 페이지 수: {}, 총 유저 수: {}",

                users.getCurrentPage(), users.getTotalPages(), users.getTotalUsers());

        return ResponseEntity.ok(users);    // 결과 DTO를 ResponseEntity에 반환
    }


}
