package org.sadmansakib.expensemanagement.shared.response.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RestResponse<T>(
        Integer httpStatus,
        String message,
        String status,
        String internalErrorCode,
        T data
) {

    public static <T> RestResponse<T> created(T data, String message) {
        return RestResponse.<T>builder()
                .httpStatus(HttpStatus.CREATED.value())
                .message(message)
                .status(HttpStatus.CREATED.name())
                .data(data)
                .build();
    }

    public static <T> RestResponse<T> ok(T data) {
        return RestResponse.<T>builder()
                .httpStatus(HttpStatus.OK.value())
                .status(HttpStatus.OK.name())
                .data(data)
                .build();
    }
}
