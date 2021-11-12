package com.dwz.a.board.service;

import com.dwz.a.board.domain.Comment;
import com.dwz.a.board.repository.BoardRepository;
import com.dwz.a.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long create(Comment comment, Long boardId) {
        comment.setBoard(boardRepository.findById(boardId));
        commentRepository.create(comment);
        return comment.getCommentId();
    }

    @Transactional
    public void update(Comment comment, Long commentId) {
        Comment updateBoard = commentRepository.findById(commentId);

        updateBoard.setContent(comment.getContent());

        commentRepository.update(updateBoard);
    }

    @Transactional
    public void delete(Long commentId) {
        Comment updateBoard = commentRepository.findById(commentId);

        updateBoard.setDeleteYn("Y");

        commentRepository.update(updateBoard);
    }
}
