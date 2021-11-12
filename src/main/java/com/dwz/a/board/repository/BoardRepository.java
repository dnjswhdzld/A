package com.dwz.a.board.repository;

import com.dwz.a.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    @Transactional
    public Long create(Board board) {
        em.persist(board);
        return board.getBoardId();
    }

    @Transactional
    public void update(Board board) {
        em.merge(board);
    }

    @Transactional
    public void delete(Board board) {
        em.merge(board);
    }

    public Board findById(Long id) {
        return em.find(Board.class, id);
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b where b.deleteYn = 'N'", Board.class)
                .getResultList();
    }

}
