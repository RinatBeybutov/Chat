package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentViewDto {
    private String text;
    private String userName;
    private LocalDateTime dateTime;
}
