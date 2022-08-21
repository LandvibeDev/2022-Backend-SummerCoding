package com.landvibe.week3.error;

import com.landvibe.week3.dto.PostCommonResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<PostCommonResDto> handleArgumentException(Exception e) {
        PostCommonResDto resDto = PostCommonResDto.builder()
                .code(-1)
                .build();

        e.printStackTrace();

        return ResponseEntity.ok(resDto);
    }
}
