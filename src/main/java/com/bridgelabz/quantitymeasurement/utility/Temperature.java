package com.bridgelabz.quantitymeasurement.utility;

public enum Temperature implements Unit {
    CELSIUS(1), FAHRENHEIT(32);

    public final double value;

    Temperature(double value) {
        this.value = value;
    }

    @Override
    public Double convert(Double value)
    {
        if (this.equals(FAHRENHEIT))
            return (value - this.value) * 5 / 9;
        return this.value * value;
    }
}
