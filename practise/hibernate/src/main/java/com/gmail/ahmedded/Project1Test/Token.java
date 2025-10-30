package com.gmail.ahmedded.Project1Test;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String age;

    // Конструктор для удобного создания объекта с username и password
    public Token(String username, String password, String age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
