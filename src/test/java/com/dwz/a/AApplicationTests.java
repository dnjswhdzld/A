package com.dwz.a;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.dwz.a.board.domain.Board;
import com.dwz.a.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
class AApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testBoard() {

        Board board = createBoard();

        Long id = boardRepository.create(board);

        Board findBoard = boardRepository.findById(id);

        Assertions.assertThat(findBoard.getId()).isEqualTo(id);

        Assertions.assertThat(boardRepository.findAll());
    }

    private Board createBoard() {

        Board board = new Board();
        board.setTitle("board title2");
        board.setContent("board contents2");
        return board;

    }

    private Board updateBoard(Board board) {

        board.setContent("modify content");

        boardRepository.update(board);

        return board;

    }


}
