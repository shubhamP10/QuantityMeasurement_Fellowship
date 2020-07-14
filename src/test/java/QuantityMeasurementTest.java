import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurement;
import com.bridgelabz.quantitymeasurement.utility.UnitType;
import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {

    QuantityMeasurement inchValue1, inchValue2, feetValue1, feetValue2, inchValue, feetValue, yardValue;

    @Test
    public void givenBothInchValuesAsZero_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue1 = new QuantityMeasurement(UnitType.INCH, 0.0);
        inchValue2 = new QuantityMeasurement(UnitType.INCH, 0.0);
        Assert.assertEquals(inchValue1, inchValue2);
    }

    @Test
    public void givenTwoSameInchValues_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue1 = new QuantityMeasurement(UnitType.INCH, 12.0);
        inchValue2 = new QuantityMeasurement(UnitType.INCH, 12.0);
        Assert.assertEquals(inchValue1, inchValue2);
    }

    @Test
    public void givenTwoSameFeetValues_ShouldReturnTrue() throws QuantityMeasurementException {
        feetValue1 = new QuantityMeasurement(UnitType.FEET, 1.0);
        feetValue2 = new QuantityMeasurement(UnitType.FEET, 1.0);
        Assert.assertEquals(feetValue1, feetValue2);
    }

    @Test
    public void givenFeetAndInchValuesAsZero_ShouldReturnTrue() throws QuantityMeasurementException {
        feetValue1 = new QuantityMeasurement(UnitType.FEET, 0.0);
        feetValue2 = new QuantityMeasurement(UnitType.FEET, 0.0);
        Assert.assertEquals(feetValue1, feetValue2);
    }

    @Test
    public void givenFeetAndInchValuesProperly_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(UnitType.INCH, 12.0);
        feetValue = new QuantityMeasurement(UnitType.FEET, 1.0);
        Assert.assertEquals(inchValue, feetValue);
    }

    @Test
    public void given3FeetAnd1Yard_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        feetValue = new QuantityMeasurement(UnitType.FEET, 3.0);
        Assert.assertEquals(yardValue,feetValue);
    }

    @Test
    public void given1FeetAnd1Yard_ShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        feetValue = new QuantityMeasurement(UnitType.FEET, 1.0);
        Assert.assertNotEquals(yardValue,feetValue);
    }

    @Test
    public void given1InchAnd1Yard_ShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        inchValue = new QuantityMeasurement(UnitType.INCH, 1.0);
        Assert.assertNotEquals(yardValue,inchValue);
    }

    @Test
    public void given36InchAnd1Yard_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        inchValue = new QuantityMeasurement(UnitType.INCH, 36.0);
        Assert.assertEquals(yardValue,inchValue);
    }

    @Test
    public void given1YardAnd3Feet_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        feetValue = new QuantityMeasurement(UnitType.FEET, 3.0);
        Assert.assertEquals(yardValue,feetValue);
    }

    @Test
    public void givenNullYardAndNullFeet_ShouldThrowException() {
        try {
            yardValue = new QuantityMeasurement(UnitType.YARD, null);
            feetValue = new QuantityMeasurement(UnitType.FEET, null);
            Assert.assertEquals(yardValue,feetValue);
        }catch (QuantityMeasurementException e){
            e.printStackTrace();
        }

    }

    @Test
    public void givenNullValueShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        boolean equals = yardValue.equals(null);
        Assert.assertFalse(equals);
    }

    @Test
    public void givenClassTypeShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        boolean equals = yardValue.equals(Object.class);
        Assert.assertFalse(equals);
    }
}
