package com.example.demo.service;

import com.example.demo.dto.CommentCreateDto;
import com.example.demo.dto.CommentViewDto;

import java.security.Principal;
import java.util.List;

public interface CommentService {

    List<CommentViewDto> getList();

    void save(String newComment, String name);

    CommentViewDto create(CommentCreateDto dto, String email);
}
