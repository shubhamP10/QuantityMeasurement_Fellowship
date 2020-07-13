import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurement;
import com.bridgelabz.quantitymeasurement.utility.UnitType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QuantityMeasurementTest {

    QuantityMeasurement quantityMeasurement;

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void givenBothInchValuesAsZero_ShouldReturnTrue() throws QuantityMeasurementException {
        double inchValue1 = quantityMeasurement.convert(UnitType.INCH, 0.0);
        double inchValue2 = quantityMeasurement.convert(UnitType.INCH, 0.0);
        boolean compare = new QuantityMeasurement().compare(inchValue1, inchValue2);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenTwoSameInchValues_ShouldReturnTrue() throws QuantityMeasurementException {
        double inchValue1 = quantityMeasurement.convert(UnitType.INCH, 12.0);
        double inchValue2 = quantityMeasurement.convert(UnitType.INCH, 12.0);
        boolean compare = new QuantityMeasurement().compare(inchValue1, inchValue2);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenTwoSameFeetValues_ShouldReturnTrue() throws QuantityMeasurementException {
        double feetValue1 = quantityMeasurement.convert(UnitType.FEET, 1.0);
        double feetValue2 = quantityMeasurement.convert(UnitType.FEET, 1.0);
        boolean compare = new QuantityMeasurement().compare(feetValue1, feetValue2);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenFeetAndInchValuesAsZero_ShouldReturnTrue() throws QuantityMeasurementException {
        double inchValue = quantityMeasurement.convert(UnitType.INCH, 0.0);
        double feetValue = quantityMeasurement.convert(UnitType.FEET, 0.0);
        boolean compare = new QuantityMeasurement().compare(inchValue, feetValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenFeetAndInchValuesProperly_ShouldReturnTrue() throws QuantityMeasurementException {
        double inchValue = quantityMeasurement.convert(UnitType.INCH, 12.0);
        double feetValue = quantityMeasurement.convert(UnitType.FEET, 1.0);
        boolean compare = new QuantityMeasurement().compare(inchValue, feetValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenFeetAndInchValuesAsNull_ShouldThrowException() {
        try {
            quantityMeasurement.convert(UnitType.INCH, null);
            quantityMeasurement.convert(UnitType.FEET, null);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(QuantityMeasurementException.class);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(e.type, QuantityMeasurementException.ExceptionType.NULL_VALUE_PROVIDED);
        }
    }

    @Test
    public void givenYardValueNull_ShouldThrowException() {
        try {
            quantityMeasurement.convert(UnitType.YARD, null);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(QuantityMeasurementException.class);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(e.type, QuantityMeasurementException.ExceptionType.NULL_VALUE_PROVIDED);
        }
    }
}
