import com.bridgelabz.quantitymeasurement.services.QuantityMeasurement;
import com.bridgelabz.quantitymeasurement.utility.UnitType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuantityMeasurementTest {

    QuantityMeasurement quantityMeasurement;

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }
    @Test
    public void givenBothInchValuesAsZero_ShouldReturnTrue() {
        double inchValue1 = quantityMeasurement.convert(UnitType.INCH, 0);
        double inchValue2 = quantityMeasurement.convert(UnitType.INCH, 0);
        boolean compare = new QuantityMeasurement().compare(inchValue1, inchValue2);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenTwoSameInchValues_ShouldReturnTrue() {
        double inchValue1 = quantityMeasurement.convert(UnitType.INCH, 12.0);
        double inchValue2 = quantityMeasurement.convert(UnitType.INCH, 12.0);
        boolean compare = new QuantityMeasurement().compare(inchValue1, inchValue2);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenTwoSameFeetValues_ShouldReturnTrue() {
        double feetValue1 = quantityMeasurement.convert(UnitType.FEET, 1.0);
        double feetValue2 = quantityMeasurement.convert(UnitType.FEET, 1.0);
        boolean compare = new QuantityMeasurement().compare(feetValue1, feetValue2);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenFeetAndInchValuesProperly_ShouldReturnTrue() {
        double inchValue = quantityMeasurement.convert(UnitType.INCH, 12.0);
        double feetValue = quantityMeasurement.convert(UnitType.FEET, 1.0);
        boolean compare = new QuantityMeasurement().compare(inchValue, feetValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenFeetAndInchValuesAsZero_ShouldReturnTrue() {
        double inchValue = quantityMeasurement.convert(UnitType.INCH, 0);
        double feetValue = quantityMeasurement.convert(UnitType.FEET, 0);
        boolean compare = new QuantityMeasurement().compare(inchValue, feetValue);
        Assert.assertTrue(compare);
    }
}
