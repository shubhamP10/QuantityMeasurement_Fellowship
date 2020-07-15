import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurement;
import com.bridgelabz.quantitymeasurement.utility.UnitType;
import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {

    QuantityMeasurement inchValue1, inchValue2, feetValue1, feetValue2, inchValue, feetValue, yardValue, centimeterValue,
            gallon, litre, millilitre, kg, gram, tonne;

    //    UC1
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

    //    UC2
    @Test
    public void given3FeetAnd1Yard_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        feetValue = new QuantityMeasurement(UnitType.FEET, 3.0);
        Assert.assertEquals(yardValue, feetValue);
    }

    @Test
    public void given1FeetAnd1Yard_ShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        feetValue = new QuantityMeasurement(UnitType.FEET, 1.0);
        Assert.assertNotEquals(yardValue, feetValue);
    }

    @Test
    public void given1InchAnd1Yard_ShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        inchValue = new QuantityMeasurement(UnitType.INCH, 1.0);
        Assert.assertNotEquals(yardValue, inchValue);
    }

    @Test
    public void given36InchAnd1Yard_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        inchValue = new QuantityMeasurement(UnitType.INCH, 36.0);
        Assert.assertEquals(yardValue, inchValue);
    }

    @Test
    public void given1YardAnd3Feet_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        feetValue = new QuantityMeasurement(UnitType.FEET, 3.0);
        Assert.assertEquals(yardValue, feetValue);
    }

    @Test
    public void givenNullYardAndNullFeet_ShouldThrowException() {
        try {
            yardValue = new QuantityMeasurement(UnitType.YARD, null);
            feetValue = new QuantityMeasurement(UnitType.FEET, null);
            Assert.assertEquals(yardValue, feetValue);
        } catch (QuantityMeasurementException e) {
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

    //    UC3
    @Test
    public void given0CentimeterAnd0Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(UnitType.INCH, 0.0);
        centimeterValue = new QuantityMeasurement(UnitType.CENTIMETER, 0.0);
        Assert.assertEquals(inchValue, centimeterValue);
    }

    @Test
    public void given2InchAnd5Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(UnitType.INCH, 2.0);
        centimeterValue = new QuantityMeasurement(UnitType.CENTIMETER, 5.0);
        Assert.assertEquals(centimeterValue, inchValue);
    }

    @Test
    public void given1InchAnd5Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(UnitType.INCH, 1.0);
        centimeterValue = new QuantityMeasurement(UnitType.CENTIMETER, 5.0);
        Assert.assertNotEquals(centimeterValue, inchValue);
    }

    @Test
    public void given1FeetAnd30Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        feetValue = new QuantityMeasurement(UnitType.FEET, 1.0);
        centimeterValue = new QuantityMeasurement(UnitType.CENTIMETER, 30.0);
        Assert.assertEquals(centimeterValue, feetValue);
    }

    @Test
    public void given1YardAnd90Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(UnitType.YARD, 1.0);
        centimeterValue = new QuantityMeasurement(UnitType.CENTIMETER, 90.0);
        Assert.assertEquals(centimeterValue, yardValue);
    }

    //    UC 4

    @Test
    public void given2InchAnd2Inch_WhenCorrect_ShouldReturn4Inch() throws QuantityMeasurementException {
        inchValue1 = new QuantityMeasurement(UnitType.INCH, 2.0);
        inchValue2 = new QuantityMeasurement(UnitType.INCH, 2.0);
        double sumOfUnits = new QuantityMeasurement().getSumOfUnits(inchValue1, inchValue2);
        Assert.assertEquals(4.0, sumOfUnits, 0.0);
    }

    @Test
    public void given1FeetAnd2Inch_WhenCorrect_ShouldReturn14Inch() throws QuantityMeasurementException {
        feetValue = new QuantityMeasurement(UnitType.FEET, 1.0);
        inchValue = new QuantityMeasurement(UnitType.INCH, 2.0);
        double sumOfUnits = new QuantityMeasurement().getSumOfUnits(feetValue, inchValue);
        Assert.assertEquals(14.0, sumOfUnits, 0.0);
    }

    @Test
    public void given1FeetAnd1Feet_WhenCorrect_ShouldReturn24Inch() throws QuantityMeasurementException {
        feetValue1 = new QuantityMeasurement(UnitType.FEET, 1.0);
        feetValue2 = new QuantityMeasurement(UnitType.FEET, 1.0);
        double sumOfUnits = new QuantityMeasurement().getSumOfUnits(feetValue1, feetValue2);
        Assert.assertEquals(24.0, sumOfUnits, 0.0);
    }

    @Test
    public void given2InchAnd2AndHalfCentimeter_WhenCorrect_ShouldReturn3Inch() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(UnitType.INCH, 2.0);
        centimeterValue = new QuantityMeasurement(UnitType.CENTIMETER, 2.5);
        double sumOfUnits = new QuantityMeasurement().getSumOfUnits(inchValue, centimeterValue);
        Assert.assertEquals(3.0, sumOfUnits, 0.0);
    }

    //    UC5

    @Test
    public void given1GallonShouldReturnEquivalentLitre() throws QuantityMeasurementException {
        gallon = new QuantityMeasurement(UnitType.GALLON, 1.0);
        litre = new QuantityMeasurement(UnitType.LITRE, 3.78);
        Assert.assertEquals(gallon, litre);
    }

    @Test
    public void given1LitreShouldReturnEquivalentMillilitre() throws QuantityMeasurementException {
        litre = new QuantityMeasurement(UnitType.LITRE, 1.0);
        millilitre = new QuantityMeasurement(UnitType.ML, 1000.0);
        Assert.assertEquals(litre, millilitre);
    }

    //    UC6

    @Test
    public void givenVolumesInGallonAndLitres_ShouldReturnSum() throws QuantityMeasurementException {
        gallon = new QuantityMeasurement(UnitType.GALLON, 1.0);
        litre = new QuantityMeasurement(UnitType.LITRE, 3.78);
        double sumOfUnits = new QuantityMeasurement().getSumOfUnits(gallon, litre);
        Assert.assertEquals(7.56, sumOfUnits, 0.0);
    }

    @Test
    public void givenVolumesInLitresAndMillilitres_ShouldReturnSum() throws QuantityMeasurementException {
        litre = new QuantityMeasurement(UnitType.LITRE, 1.0);
        millilitre = new QuantityMeasurement(UnitType.ML, 1000.0);
        double sumOfUnits = new QuantityMeasurement().getSumOfUnits(litre, millilitre);
        Assert.assertEquals(2.0, sumOfUnits, 0.0);
    }

    //    UC7

    @Test
    public void givenWeightInKgShouldReturnEquivalentWeightInGrams() throws QuantityMeasurementException {
        kg = new QuantityMeasurement(UnitType.KILOGRAM, 1.0);
        gram = new QuantityMeasurement(UnitType.GRAM, 1000.0);
        Assert.assertEquals(kg, gram);
    }
}
