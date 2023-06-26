package com.blog.entity;

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
public class UserInfo {

    @Id
    private String id;
    @Indexed(unique = true, background = true)
    private String mobileNumber;

}
