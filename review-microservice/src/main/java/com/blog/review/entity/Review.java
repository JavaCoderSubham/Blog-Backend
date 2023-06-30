package com.blog.review.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String userId;
    @NotNull
    private String blogId;
    @NotNull
    private String userName;
    @Max(value = 5, message = "Rating Must be less_than or equal to 5")
    @Min(value = 1, message = "Rating Must be greater_than or equal to 1")
    @NotNull
    private Integer rating;
    @NotNull
    private String comment;

}
