package com.dwz.a.board.controller;

import com.dwz.a.board.domain.Board;
import com.dwz.a.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create-board")
    public String createBoard(Board board) {
        Board createBoard = new Board();
        createBoard.setTitle(board.getTitle());
        createBoard.setContent(board.getContent());
        Long boardId = boardService.create(board);
        return "redirect:/";
    }

    @PostMapping("/update-board")
    public String updateBoard(Long boardId, Board board) {
        boardService.update(boardId, board);
        return "redirect:/";
    }

    @PostMapping("/delete-board")
    public String deleteBoard(Long boardId) {
        boardService.delete(boardId);
        return "redirect:/";
    }

    @GetMapping("/board")
    public String board(Model model, Long boardId) {
        Board boardList = boardService.findOne(boardId);
        model.addAttribute("boards", boardList);
        return "redirect:/";
    }

    @GetMapping("/board-list")
    public String boardList(Model model) {
        List<Board> boardList = boardService.findBoardList();
        model.addAttribute("boards", boardList);
        return "redirect:/";
    }


}
