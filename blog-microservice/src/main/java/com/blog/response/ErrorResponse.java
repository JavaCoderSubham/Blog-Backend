package com.blog.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponse {
    private String timeStamp;
    private String error;
    private String uri;
}
