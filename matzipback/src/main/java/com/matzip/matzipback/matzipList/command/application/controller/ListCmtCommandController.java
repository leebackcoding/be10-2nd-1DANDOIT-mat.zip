package com.matzip.matzipback.matzipList.command.application.controller;

import com.matzip.matzipback.matzipList.command.application.dto.CreateListCmtRequest;
import com.matzip.matzipback.matzipList.command.application.dto.DeleteListCmtRequset;
import com.matzip.matzipback.matzipList.command.application.service.ListCmtCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ListCmtCommandController {

    private final ListCmtCommandService listCmtCommandService;

    // 리스트 댓글 등록
    @PostMapping("/list/comment")
    public ResponseEntity<Void> createListCmt(@RequestBody CreateListCmtRequest listCmtRequest){

        Long listCmtSeq = listCmtCommandService.createListCmt(listCmtRequest);

        return ResponseEntity.created(URI.create("/api/v1/list/comment" + listCmtSeq)).build();
    }

    // 리스트 댓글 삭제
    @DeleteMapping("/list/comment")
    public ResponseEntity<Void> deleteListCmt(@Valid @RequestBody DeleteListCmtRequset deleteListCmtRequset){

        listCmtCommandService.deleteListCmt(deleteListCmtRequset);

        return ResponseEntity.noContent().build();
    }
}
