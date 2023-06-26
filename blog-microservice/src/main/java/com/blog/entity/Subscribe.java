package com.blog.entity;

import jdk.jfr.StackTrace;
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
public class Subscribe {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true, background = true)
    private String email;
    @Indexed(unique = true, background = true)
    private String mobileNumber;
    private boolean activeSubscribe;
}
