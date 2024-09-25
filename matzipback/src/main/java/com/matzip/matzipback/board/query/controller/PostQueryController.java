package com.matzip.matzipback.board.query.controller;

import com.matzip.matzipback.board.query.dto.PostListResponse;
import com.matzip.matzipback.board.query.service.PostQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostQueryController {

    private final PostQueryService postQueryService;

    /* 1. 검색조건(게시글 제목, 게시글 작성자 닉네임)에 맞는 게시글 목록 조회 */
    @GetMapping("/post/search")
    public ResponseEntity<PostListResponse> searchPosts(
            // paging 처리
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String postTitle,      // 검색조건1: 게시글 제목
            @RequestParam(required = false) String userNickname    // 검색조건2: 게시글 작성자 닉네임
    ) {

        PostListResponse response = postQueryService.searchPosts(page, size, postTitle, userNickname);

        return ResponseEntity.ok(response);
    }
}