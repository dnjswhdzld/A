package com.dwz.a.board.service;

import com.dwz.a.board.domain.Board;
import com.dwz.a.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional
    public Long post(Board board) {
        boardRepository.create(board);
        return board.getId();
    }

    public List<Board> findPosts() {
        return boardRepository.findAll();
    }


}
