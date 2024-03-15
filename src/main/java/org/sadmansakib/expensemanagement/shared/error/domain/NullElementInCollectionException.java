package org.sadmansakib.expensemanagement.shared.error.domain;

public class NullElementInCollectionException extends AssertionException {

    public NullElementInCollectionException(String field) {
        super(field, message(field));
    }

    private static String message(String field) {
        return STR."The field \"\{field}\" contains a null element";
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.NULL_ELEMENT_IN_COLLECTION;
    }
}