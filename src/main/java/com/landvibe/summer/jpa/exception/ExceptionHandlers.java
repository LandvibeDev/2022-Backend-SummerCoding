package com.landvibe.summer.jpa.exception;

import com.landvibe.summer.jpa.dto.response.PostCommonRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<PostCommonRes> handler(Exception e) {
        PostCommonRes postCommonRes = PostCommonRes.builder()
                .code(-1)
                .build();
        e.printStackTrace();
        return ResponseEntity.ok(postCommonRes);
    }
}
