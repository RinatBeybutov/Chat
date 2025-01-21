package com.example.demo.service;

import com.example.demo.dto.CommentViewDto;
import com.example.demo.entity.CommentEntity;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    private final CommentMapper mapper;

    private final UserService userService;

    @Override
    public List<CommentViewDto> getList() {
        return repository.findTop10OrderByDatetime()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void save(String newComment, String email) {
        CommentEntity comment = new CommentEntity();
        comment.setText(newComment);
        comment.setDateTime(LocalDateTime.now());

        var user = userService.getUserByEmail(email);
        comment.setUser(user);

        repository.save(comment);
    }
}
