package com.test.location.util;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;
}
