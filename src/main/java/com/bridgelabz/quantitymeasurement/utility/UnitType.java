package com.bridgelabz.quantitymeasurement.utility;

public enum UnitType {

    INCH(1), FEET(12), YARD(36);

    public final double value;

    UnitType(double value) {
        this.value = value;
    }
}