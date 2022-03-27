package com.javaparams.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "jp_vote")
public class Vote {

    @Id
    private Long id;

    @ManyToOne
    private Combo combo;

    @ManyToOne
    private User user;

    private Boolean liked;
}
