package com.javaparams.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "jp_favorite")
public class Favorite {

    @Id
    private Long id;

    @ManyToOne
    private Combo combo;

    @ManyToOne
    private User user;

}
