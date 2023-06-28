package com.blog.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {

    private String id;
    private String userId;
    private String userName;
    private String blogId;
    private Integer rating;
    private String comment;

}
