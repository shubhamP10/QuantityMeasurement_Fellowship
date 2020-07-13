package com.bridgelabz.quantitymeasurement.exception;

public class QuantityMeasurementException extends Exception {
    public ExceptionType type;

    public QuantityMeasurementException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        NULL_VALUE_PROVIDED
    }
}
