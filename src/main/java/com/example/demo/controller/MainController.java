package com.example.demo.controller;

import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final CommentService commentService;

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("messages", commentService.getList());
        return "index";
    }

    @PostMapping
    public String addComment(@RequestParam("newComment") String newComment) {
        // save comment
        commentService.save(newComment);
        return "redirect:/main";
    }
}
