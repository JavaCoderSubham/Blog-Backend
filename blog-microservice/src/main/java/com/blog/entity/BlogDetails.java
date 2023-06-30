package com.blog.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
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
@Document
public class BlogDetails {

    @Id
    private String id;
    @NotNull
    private String author;
    @NotNull
    private String title;
    @NotNull
    private String topic;
    @NotNull
    private String email;
    @NotNull
    private String blogText;
    @NotNull
    private String imagePath;
    private List<String> hashTags;
    @Transient
    private List<Review> review;

}




