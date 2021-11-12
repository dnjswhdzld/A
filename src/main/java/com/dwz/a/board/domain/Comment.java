package com.dwz.a.board.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@DynamicInsert
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    private String content;

    @ColumnDefault("'N'")
    private String deleteYn;
}
