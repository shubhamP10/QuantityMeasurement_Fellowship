package com.bridgelabz.quantitymeasurement.services;

import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import com.bridgelabz.quantitymeasurement.utility.UnitType;

public class QuantityMeasurement {

    private double value;

    public QuantityMeasurement() {
    }

    public double convert(UnitType unitType, Double value) throws QuantityMeasurementException {
        if (value == null) {
            throw new QuantityMeasurementException("NULL Value Provided", QuantityMeasurementException.ExceptionType.NULL_VALUE_PROVIDED);
        }
        return (value * unitType.value);
    }

    public boolean compare(double value1, double value2) {
        return Double.compare(value1, value2) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;         //ref check
        if (o == null || getClass() != o.getClass()) return false;      //null n type check
        QuantityMeasurement quantityMeasurement = (QuantityMeasurement) o;  //converting obj param to type of QM
        return this.compare(quantityMeasurement.value, value);      //value check
    }
}
