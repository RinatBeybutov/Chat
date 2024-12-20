package com.example.demo.controller;

import com.example.demo.dto.CommentViewDto;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final CommentService commentService;

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("messages", commentService.getList());
        //model.addAttribute("dto", new CommentViewDto());
        return "index";
    }

    @PostMapping
    public String addComment(@RequestParam("newComment") String newComment) {
        // save comment
        commentService.save(newComment);
        return "redirect:/main";
    }
}
