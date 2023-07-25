package com.blog.userInfo.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Review {

	
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
