package com.blog.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Review {

    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String userId;
    @NotNull
    private String userName;
    @NotNull
    private String blogId;
    @NotNull
    private Integer rating;
    @NotNull
    private String comment;

}
