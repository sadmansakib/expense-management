package org.sadmansakib.expensemanagement.shared.error.domain;

import java.util.Map;

public abstract class AssertionException extends ExpenseManagementException {

    private final String field;

    protected AssertionException(String field, String message) {
        super(message, 400);
        this.field = field;
    }

    public abstract AssertionErrorType type();

    public String field() {
        return field;
    }

    public Map<String, String> parameters() {
        return Map.of();
    }
}