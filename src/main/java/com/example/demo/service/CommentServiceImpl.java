package com.example.demo.service;

import com.example.demo.dto.CommentCreateDto;
import com.example.demo.dto.CommentViewDto;
import com.example.demo.entity.CommentEntity;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    private final CommentMapper mapper;

    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
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

    @Override
    public CommentViewDto create(CommentCreateDto dto, String email) {
        CommentEntity entity = mapper.toEntity(dto);

        //CommentEntity comment = new CommentEntity();
        //comment.setText(dto.getText());
        //comment.setDateTime(LocalDateTime.now());

        var user = userService.getUserByEmail(email);
        entity.setUser(user);

        entity = repository.save(entity);

        return mapper.toDto(entity);
    }
}
