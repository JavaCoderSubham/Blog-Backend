package com.blog.admin.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {

    private String id;
    private String userId;
    private String blogId;
    private String userName;
    private Integer rating;
    private String comment;

}
