package org.sadmansakib.expensemanagement.shared.error.domain;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExpenseManagementException extends RuntimeException {
    private final HttpStatus status;
    public ExpenseManagementException(String message) {
        super(message);
        status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ExpenseManagementException(String message, Integer status) {
        super(message);
        this.status = HttpStatus.valueOf(status);
    }
}
