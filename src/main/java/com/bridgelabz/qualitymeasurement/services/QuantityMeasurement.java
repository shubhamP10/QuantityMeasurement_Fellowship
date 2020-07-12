package com.bridgelabz.qualitymeasurement.services;

import com.bridgelabz.qualitymeasurement.utility.UnitType;

public class QuantityMeasurement {

    public double convert(UnitType unitType, double value) {
        return (value * unitType.returnValue());
    }

    public boolean compare(double value1, double value2) {
        return Double.compare(value1, value2) == 0;
    }
}
