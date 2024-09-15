package org.back.domain.exception;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final ModelMapper mapper = new ModelMapper();

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> launcherCustomException(CustomException ex) {
        CustomExceptionMask mask = new CustomExceptionMask();

        mapper.map(ex, mask);

        return new ResponseEntity<>(mask, ex.getStatus());
    }

}
