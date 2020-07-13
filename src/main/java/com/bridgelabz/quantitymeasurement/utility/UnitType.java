package com.bridgelabz.quantitymeasurement.utility;

public enum UnitType {

    INCH(1), FEET(12);

    private final double value;

    UnitType(double value) {
        this.value = value;
    }

    public double returnValue() {
        return value;
    }
}