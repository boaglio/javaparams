package com.javaparams.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "jp_parameter")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {

    @Id
    private Long   id;
    private String name;
    private String description;

}
