package com.blog.entity;

<<<<<<< HEAD
import java.util.List;

=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.*;
>>>>>>> a8e5cab3f40d0c6b381a7183d6c899ddd3f37f3f
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

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




