package com.dwz.a.board.repository;

import com.dwz.a.board.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    @Transactional
    public Long create(Comment comment) {
        em.persist(comment);
        return comment.getCommentId();
    }

    @Transactional
    public void update(Comment comment) {
        em.merge(comment);
    }

    public Comment findById(Long commentId) {
        return em.find(Comment.class, commentId);
    }

}
