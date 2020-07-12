import com.bridgelabz.qualitymeasurement.services.QuantityMeasurement;
import com.bridgelabz.qualitymeasurement.utility.UnitType;
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
    public void givenFeetAndInchValuesProperly_ShouldReturnTrue() {
        double inchValue = quantityMeasurement.convert(UnitType.INCH, 12.0);
        double feetValue = quantityMeasurement.convert(UnitType.FEET, 1.0);
        boolean compare = new QuantityMeasurement().compare(inchValue, feetValue);
        Assert.assertTrue(compare);
    }
}
