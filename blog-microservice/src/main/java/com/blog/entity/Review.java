package com.blog.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
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
    private String postId;
    private String mobileNumber;
    private Long views;     // It Go to blogDetails entity class TODO
    private Integer rating;
    private String comment;

}
