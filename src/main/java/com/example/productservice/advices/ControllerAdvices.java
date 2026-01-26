package com.example.productservice.advices;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.dto.ErrorResponseDto;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
@RestController
public class ControllerAdvices {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRuntimeException(RuntimeException e) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setStatus("Status");
        dto.setMessage(e.getMessage());
        return dto;
    }

        @ExceptionHandler(ProductNotFoundException.class)
         ErrorResponseDto handleProductNotFound(ProductNotFoundException e){
            ErrorResponseDto dto2 = new ErrorResponseDto();
            dto2.setStatus("Not found");
            dto2.setMessage(e.getMessage());
            return dto2;


}
}
