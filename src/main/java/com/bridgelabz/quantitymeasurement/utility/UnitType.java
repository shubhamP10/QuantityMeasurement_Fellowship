package com.bridgelabz.quantitymeasurement.utility;

public enum UnitType {

    INCH(1), FEET(12), YARD(36), CENTIMETER(0.4),
    LITRE(1), ML(0.001), GALLON(3.78);

    public final double value;

    UnitType(double value) {
        this.value = value;
    }
}