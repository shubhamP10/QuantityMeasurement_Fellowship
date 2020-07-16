package com.bridgelabz.quantitymeasurement.utility;

public enum Weight implements Unit {
    KILOGRAM(1), GRAM(0.001), TONNE(1000);

    public final double value;

    Weight(double value) {
        this.value = value;
    }
    @Override
    public Double convert(Double value) {
        return this.value * value;
    }
}
