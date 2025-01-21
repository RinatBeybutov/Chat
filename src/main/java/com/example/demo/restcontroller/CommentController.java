package com.example.demo.restcontroller;

import com.example.demo.dto.CommentViewDto;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentViewDto>> getUsers() {
        return ResponseEntity.ok(commentService.getList());
    }

    // TODO: добавить запрос на создание комментария
}
