package com.example.demo.mapper;

import com.example.demo.dto.CommentCreateDto;
import com.example.demo.dto.CommentViewDto;
import com.example.demo.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "userName", source = "user.name")
    CommentViewDto toDto(CommentEntity cityEntity);

    @Mapping(target = "dateTime", expression = "java(java.time.LocalDateTime.now())")
    CommentEntity toEntity(CommentCreateDto dto);
}
