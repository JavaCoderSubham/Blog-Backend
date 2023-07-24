package com.blog.admin.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogDetails {

    private String id;
    private String author;
    private String title;
    private String topic;
    private String email;
    private String blogText;
    private String imagePath;
    private List<String> hashTags;
    private List<Review> review;

}




