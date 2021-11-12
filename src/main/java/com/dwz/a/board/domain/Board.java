package com.dwz.a.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@DynamicInsert
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long boardId;

    private String title;
    private String content;

    @ColumnDefault("'N'")
    private String deleteYn;

    @JsonIgnore
    @OneToMany(mappedBy = "board")
    private List<Comment> comments;
}
