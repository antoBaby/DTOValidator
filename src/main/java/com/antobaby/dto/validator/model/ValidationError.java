package com.antobaby.dto.validator.model;

public class ValidationError {

    private String field;
    private String message;
    private String details;
    private ValidationRule validationRule;

    public ValidationError(String field, String message, String details, ValidationRule validationRule) {
        this.field = field;
        this.message = message;
        this.details = details;
        this.validationRule = validationRule;
    }

    public ValidationError(String field, String message, String details) {
        this.field = field;
        this.message = message;
        this.details = details;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ValidationRule getValidationRule() {
        return validationRule;
    }

    public void setValidationRule(ValidationRule validationRule) {
        this.validationRule = validationRule;
    }
}
