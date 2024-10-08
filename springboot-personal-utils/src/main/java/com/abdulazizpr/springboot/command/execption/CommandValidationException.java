package com.abdulazizpr.springboot.command.execption;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class CommandValidationException extends RuntimeException {

    private Set<ConstraintViolation<?>> constraintViolations;

    @SuppressWarnings("unchecked")
    public CommandValidationException(Set constraintViolations) {
        this.constraintViolations = (Set<ConstraintViolation<?>>) constraintViolations;
    }

    public Set<ConstraintViolation<?>> getConstraintViolations() {
        return constraintViolations;
    }
}
