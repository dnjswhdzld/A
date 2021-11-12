package com.dwz.a.board.controller;


import com.dwz.a.board.domain.Comment;
import com.dwz.a.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create-comment")
    public String createComment(Comment comment, Long boardId) {
        commentService.create(comment, boardId);
        return "redirect:/";
    }

    @PostMapping("/update-comment")
    public String updateComment(Comment comment, Long commentId) {
        commentService.update(comment, commentId);
        return "redirect:/";
    }

    @PostMapping("/delete-comment")
    public String deleteComment(Long commentId) {
        commentService.delete(commentId);
        return "redirect:/";
    }

}
