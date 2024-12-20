package com.example.demo.mapper;

import com.example.demo.dto.CommentViewDto;
import com.example.demo.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    //@Mapping(target = "text", source = "text")
    @Mapping(target = "userName", source = "user.name")
    //@Mapping(target = "dateTime", source = "dateTime")
    CommentViewDto toDto(CommentEntity cityEntity);
}
