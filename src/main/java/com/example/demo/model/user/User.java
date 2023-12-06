package com.example.demo.model.user;

import com.example.demo.model.portfolio.Portfolio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@AllArgsConstructor
@Document("users")
public class User {
    @Id
    private String id;

    @Field("name")
    private String name;
    @Field("nickname")
    private String nickname;
    @Field("age")
    private int age;
    @Field("portfolios")
    private Set<@Valid Portfolio> portfolios;
}
