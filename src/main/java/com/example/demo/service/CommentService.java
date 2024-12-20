package com.example.demo.service;

import com.example.demo.dto.CommentViewDto;

import java.util.List;

public interface CommentService {

    List<CommentViewDto> getList();

    void save(String newComment);
}
