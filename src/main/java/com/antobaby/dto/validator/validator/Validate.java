package com.antobaby.dto.validator.validator;

import com.antobaby.dto.validator.model.ValidationError;
import com.antobaby.dto.validator.model.ValidationRule;

public interface Validate {

    ValidationError validateRule(Object document, ValidationRule validationRule);
}
