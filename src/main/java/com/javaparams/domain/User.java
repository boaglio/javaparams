package com.javaparams.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@ToString
@Table(name = "jp_user")
public class User {

    @Id
    private String id;

    private String name;

    private LocalDateTime lastLogin;

}
