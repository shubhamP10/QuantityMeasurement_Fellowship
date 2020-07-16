package com.bridgelabz.quantitymeasurement.services;

import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import com.bridgelabz.quantitymeasurement.utility.Temperature;
import com.bridgelabz.quantitymeasurement.utility.Unit;

public class QuantityMeasurement {
    private Unit unit;
    private double value;

    public QuantityMeasurement(Unit unit, Double value) throws QuantityMeasurementException {
        if (value == null)
            throw new QuantityMeasurementException("Null Value Provided",
                                                QuantityMeasurementException.ExceptionType.NULL_VALUE_PROVIDED);
        this.value = value;
        this.unit = unit;
    }

    public boolean compare(QuantityMeasurement that) throws QuantityMeasurementException {
        if (!this.unit.getClass().equals(that.unit.getClass()))
            throw new QuantityMeasurementException("Units Not Comparable", QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE);
        Double firstValue = this.unit.convert(this.value);
        Double secondValue = that.unit.convert(that.value);
        return (Double.compare(Math.round(firstValue), Math.round(secondValue)) == 0);
    }

    public Double additionOfUnits(QuantityMeasurement that) throws QuantityMeasurementException {
        if (this.unit.getClass().getName().equals(Temperature.class.getName()) | that.unit.getClass().getName().equals(Temperature.class.getName()))
            throw new QuantityMeasurementException("Units Not Addable", QuantityMeasurementException.ExceptionType.UNIT_NOT_ADDABLE);
        Double firstValue = this.unit.convert(this.value);
        Double secondValue = that.unit.convert(that.value);
        return (firstValue + secondValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.value, value) == 0 &&
                unit == that.unit;
    }
}
