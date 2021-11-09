package com.dwz.a.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter
public class Comment {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String name;

    private String content;

}
