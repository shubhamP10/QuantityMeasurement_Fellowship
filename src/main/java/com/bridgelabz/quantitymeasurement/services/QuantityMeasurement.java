package com.bridgelabz.quantitymeasurement.services;

import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import com.bridgelabz.quantitymeasurement.utility.UnitType;

public class QuantityMeasurement {

    public double convert(UnitType unitType, Double value) throws QuantityMeasurementException {
        if (value == null) {
            throw new QuantityMeasurementException("NULL Value Provided", QuantityMeasurementException.ExceptionType.NULL_VALUE_PROVIDED);
        }
        return (value * unitType.returnValue());
    }

    public boolean compare(double value1, double value2) {
        return Double.compare(value1, value2) == 0;
    }
}
