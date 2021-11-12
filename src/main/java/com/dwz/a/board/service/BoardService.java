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
    public Long create(Board board) {
        boardRepository.create(board);
        return board.getBoardId();
    }

    @Transactional
    public void update(Long boardId, Board board) {
        Board updateBoard = boardRepository.findById(boardId);

        updateBoard.setContent(board.getContent());

        boardRepository.update(updateBoard);
    }

    @Transactional
    public void delete(Long boardId) {
        Board deleteBoard = boardRepository.findById(boardId);

        deleteBoard.setDeleteYn("Y");

        boardRepository.update(deleteBoard);
    }

    public Board findOne(Long boardId) {
        return boardRepository.findById(boardId);
    }

    public List<Board> findBoardList() {
        return boardRepository.findAll();
    }


}
