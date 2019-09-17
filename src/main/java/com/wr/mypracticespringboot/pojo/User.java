package com.wr.mypracticespringboot.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wangru
 *
 */
@Entity
@Data
@Table(name="t_admin")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String username;

    String password;
}
