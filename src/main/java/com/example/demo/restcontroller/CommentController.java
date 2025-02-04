package com.example.demo.restcontroller;

import com.example.demo.dto.CommentCreateDto;
import com.example.demo.dto.CommentViewDto;
import com.example.demo.service.CommentService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.example.demo.config.API.COMMENTS;

@RestController
@RequestMapping(COMMENTS)
@RequiredArgsConstructor
@Tag(name = "Comments", description = "АПИ для работы с комментариями")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    @Operation(summary = "Получение комментариев")
    public ResponseEntity<List<CommentViewDto>> getComments() {
        return ResponseEntity.ok(commentService.getList());
    }

    @PostMapping
    @Operation(summary = "Создание комментария")
    //@Hidden
    public ResponseEntity<CommentViewDto> create(@RequestBody CommentCreateDto dto,
                                                 @RequestParam Integer num,
                                                 Principal user) {
        System.out.println(num);
        String email = user == null ? "gaben@gmail.com" : user.getName();
        return ResponseEntity.ok(commentService.create(dto, email));
    }
}
