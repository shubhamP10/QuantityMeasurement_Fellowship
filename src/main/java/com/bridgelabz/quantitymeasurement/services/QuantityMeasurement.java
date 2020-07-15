package com.bridgelabz.quantitymeasurement.services;

import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import com.bridgelabz.quantitymeasurement.utility.UnitType;

public class QuantityMeasurement {
    private double value;

    /**
     *
     * @param unitType
     * @param value
     * @throws QuantityMeasurementException
     */
    public QuantityMeasurement(UnitType unitType, Double value) throws QuantityMeasurementException {
        try {
            this.value = (value * unitType.value);
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException("Null Value Provided",
                    QuantityMeasurementException.ExceptionType.NULL_VALUE_PROVIDED);
        }
    }

    public QuantityMeasurement() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Reference Check
        if (o == null || getClass() != o.getClass()) return false; // Null Check And Type Check
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.value, value) == 0;  // Value Check
    }

    public double getSumOfUnits(QuantityMeasurement value1, QuantityMeasurement value2) {
        return value1.value + value2.value;
    }
}
