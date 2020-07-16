package com.bridgelabz.quantitymeasurement.utility;

public enum Volume implements Unit {
    LITRE(1), ML(0.001), GALLON(3.78);

    public final double value;

    Volume(double value) {
        this.value = value;
    }
    @Override
    public Double convert(Double value) {
        return this.value * value;
    }
}
