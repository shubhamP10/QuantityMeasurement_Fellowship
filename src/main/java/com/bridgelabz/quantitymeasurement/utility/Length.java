package com.bridgelabz.quantitymeasurement.utility;

public enum  Length implements Unit {

    INCH(1), FEET(12), YARD(36), CENTIMETER(0.4);

    public final double value;

    Length(double value) {
        this.value = value;
    }


    @Override
    public Double convert(Double value) {
        return this.value * value;
    }
}
