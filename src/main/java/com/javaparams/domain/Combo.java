package com.javaparams.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "jp_combo")
public class Combo {

    @Id
    private Long            id;
    private String          name;
    private String          description;
    @OneToMany
    private List<Parameter> params;
    private Long            totalLikes;
    private Long            totalDislikes;

}
