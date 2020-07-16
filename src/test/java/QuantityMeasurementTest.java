import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurement;
import com.bridgelabz.quantitymeasurement.utility.*;
import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {

    QuantityMeasurement inchValue1, inchValue2, feetValue1, feetValue2, inchValue, feetValue, yardValue, centimeterValue,
            gallon, litre, millilitre, kg, gram, tonne, celsius, fahrenheit;

    //    UC1
    @Test
    public void givenBothInchValuesAsZero_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue1 = new QuantityMeasurement(Length.INCH, 0.0);
        inchValue2 = new QuantityMeasurement(Length.INCH, 0.0);
        Assert.assertEquals(inchValue1, inchValue2);
    }

    @Test
    public void givenTwoSameInchValues_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue1 = new QuantityMeasurement(Length.INCH, 12.0);
        inchValue2 = new QuantityMeasurement(Length.INCH, 12.0);
        Assert.assertEquals(inchValue1, inchValue2);
    }

    @Test
    public void givenTwoSameFeetValues_ShouldReturnTrue() throws QuantityMeasurementException {
        feetValue1 = new QuantityMeasurement(Length.FEET, 1.0);
        feetValue2 = new QuantityMeasurement(Length.FEET, 1.0);
        Assert.assertEquals(feetValue1, feetValue2);
    }

    @Test
    public void givenFeetAndInchValuesAsZero_ShouldReturnTrue() throws QuantityMeasurementException {
        feetValue1 = new QuantityMeasurement(Length.FEET, 0.0);
        feetValue2 = new QuantityMeasurement(Length.FEET, 0.0);
        Assert.assertEquals(feetValue1, feetValue2);
    }

    @Test
    public void givenFeetAndInchValuesProperly_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(Length.INCH, 12.0);
        feetValue = new QuantityMeasurement(Length.FEET, 1.0);
        boolean compare = inchValue.compare(feetValue);
        Assert.assertTrue(compare);
    }

    //    UC2
    @Test
    public void given3FeetAnd1Yard_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(Length.YARD, 1.0);
        feetValue = new QuantityMeasurement(Length.FEET, 3.0);
        boolean compare = yardValue.compare(feetValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void given1FeetAnd1Yard_ShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(Length.YARD, 1.0);
        feetValue = new QuantityMeasurement(Length.FEET, 1.0);
        boolean compare = yardValue.compare(feetValue);
        Assert.assertFalse(compare);
    }

    @Test
    public void given1InchAnd1Yard_ShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(Length.YARD, 1.0);
        inchValue = new QuantityMeasurement(Length.INCH, 1.0);
        boolean compare = yardValue.compare(inchValue);
        Assert.assertFalse(compare);
    }

    @Test
    public void given36InchAnd1Yard_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(Length.YARD, 1.0);
        inchValue = new QuantityMeasurement(Length.INCH, 36.0);
        boolean compare = yardValue.compare(inchValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void given1YardAnd3Feet_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(Length.YARD, 1.0);
        feetValue = new QuantityMeasurement(Length.FEET, 3.0);
        boolean compare = yardValue.compare(feetValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenNullYardAndNullFeet_ShouldThrowException() {
        try {
            yardValue = new QuantityMeasurement(Length.YARD, null);
            feetValue = new QuantityMeasurement(Length.FEET, null);
            boolean compare = yardValue.compare(feetValue);
            Assert.assertTrue(compare);
        }catch (QuantityMeasurementException e){
            Assert.assertEquals(e.type, QuantityMeasurementException.ExceptionType.NULL_VALUE_PROVIDED);
        }


    }

    @Test
    public void givenNullValueShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(Length.YARD, 1.0);
        boolean equals = yardValue.equals(null);
        Assert.assertFalse(equals);
    }

    @Test
    public void givenClassTypeShouldReturnFalse() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(Length.YARD, 1.0);
        boolean equals = yardValue.equals(Object.class);
        Assert.assertFalse(equals);
    }

    //    UC3
    @Test
    public void given0CentimeterAnd0Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(Length.INCH, 0.0);
        centimeterValue = new QuantityMeasurement(Length.CENTIMETER, 0.0);
        boolean compare = inchValue.compare(centimeterValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void given2InchAnd5Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(Length.INCH, 2.0);
        centimeterValue = new QuantityMeasurement(Length.CENTIMETER, 5.0);
        boolean compare = inchValue.compare(centimeterValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void given1InchAnd5Centimeter_ShouldReturnFalse() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(Length.INCH, 1.0);
        centimeterValue = new QuantityMeasurement(Length.CENTIMETER, 5.0);
        boolean compare = inchValue.compare(centimeterValue);
        Assert.assertFalse(compare);
    }

    @Test
    public void given1FeetAnd30Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        feetValue = new QuantityMeasurement(Length.FEET, 1.0);
        centimeterValue = new QuantityMeasurement(Length.CENTIMETER, 30.0);
        boolean compare = feetValue.compare(centimeterValue);
        Assert.assertTrue(compare);
    }

    @Test
    public void given1YardAnd90Centimeter_ShouldReturnTrue() throws QuantityMeasurementException {
        yardValue = new QuantityMeasurement(Length.YARD, 1.0);
        centimeterValue = new QuantityMeasurement(Length.CENTIMETER, 90.0);
        boolean compare = yardValue.compare(centimeterValue);
        Assert.assertTrue(compare);
    }

    //    UC 4

    @Test
    public void given2InchAnd2Inch_WhenCorrect_ShouldReturn4Inch() throws QuantityMeasurementException {
        inchValue1 = new QuantityMeasurement(Length.INCH, 2.0);
        inchValue2 = new QuantityMeasurement(Length.INCH, 2.0);
        double sumOfUnits = inchValue1.additionOfUnits(inchValue2);
        Assert.assertEquals(4.0, sumOfUnits, 0.0);
    }

    @Test
    public void given1FeetAnd2Inch_WhenCorrect_ShouldReturn14Inch() throws QuantityMeasurementException {
        feetValue = new QuantityMeasurement(Length.FEET, 1.0);
        inchValue = new QuantityMeasurement(Length.INCH, 2.0);
        double sumOfUnits = feetValue.additionOfUnits(inchValue);
        Assert.assertEquals(14.0, sumOfUnits, 0.0);
    }

    @Test
    public void given1FeetAnd1Feet_WhenCorrect_ShouldReturn24Inch() throws QuantityMeasurementException {
        feetValue1 = new QuantityMeasurement(Length.FEET, 1.0);
        feetValue2 = new QuantityMeasurement(Length.FEET, 1.0);
        double sumOfUnits = feetValue1.additionOfUnits(feetValue2);
        Assert.assertEquals(24.0, sumOfUnits, 0.0);
    }

    @Test
    public void given2InchAnd2AndHalfCentimeter_WhenCorrect_ShouldReturn3Inch() throws QuantityMeasurementException {
        inchValue = new QuantityMeasurement(Length.INCH, 2.0);
        centimeterValue = new QuantityMeasurement(Length.CENTIMETER, 2.5);
        double sumOfUnits = inchValue.additionOfUnits(centimeterValue);
        Assert.assertEquals(3.0, sumOfUnits, 0.0);
    }

    //    UC5

    @Test
    public void given1GallonShouldReturnEquivalentLitre() throws QuantityMeasurementException {
        gallon = new QuantityMeasurement(Volume.GALLON, 1.0);
        litre = new QuantityMeasurement(Volume.LITRE, 3.78);
        boolean compare = gallon.compare(litre);
        Assert.assertTrue(compare);
    }

    @Test
    public void given1LitreShouldReturnEquivalentMillilitre() throws QuantityMeasurementException {
        litre = new QuantityMeasurement(Volume.LITRE, 1.0);
        millilitre = new QuantityMeasurement(Volume.ML, 1000.0);
        boolean compare = litre.compare(millilitre);
        Assert.assertTrue(compare);
    }

    //    UC6

    @Test
    public void givenVolumesInGallonAndLitres_ShouldReturnSum() throws QuantityMeasurementException {
        gallon = new QuantityMeasurement(Volume.GALLON, 1.0);
        litre = new QuantityMeasurement(Volume.LITRE, 3.78);
        double sumOfUnits = gallon.additionOfUnits(litre);
        Assert.assertEquals(7.56, sumOfUnits, 0.0);
    }

    @Test
    public void givenVolumesInLitresAndMillilitres_ShouldReturnSum() throws QuantityMeasurementException {
        litre = new QuantityMeasurement(Volume.LITRE, 1.0);
        millilitre = new QuantityMeasurement(Volume.ML, 1000.0);
        double sumOfUnits = litre.additionOfUnits(millilitre);
        Assert.assertEquals(2.0, sumOfUnits, 0.0);
    }

    //    UC7

    @Test
    public void givenWeightIn1KgShouldReturnEquivalentWeightInGrams() throws QuantityMeasurementException {
        kg = new QuantityMeasurement(Weight.KILOGRAM, 1.0);
        gram = new QuantityMeasurement(Weight.GRAM, 1000.0);
        boolean compare = kg.compare(gram);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenWeightIn1TonneShouldReturnEquivalentWeightInKiloGrams() throws QuantityMeasurementException {
        tonne = new QuantityMeasurement(Weight.TONNE, 1.0);
        kg = new QuantityMeasurement(Weight.KILOGRAM, 1000.0);
        boolean compare = tonne.compare(kg);
        Assert.assertTrue(compare);
    }

    @Test
    public void givenWeightIn1TonneAnd1000Gram_ShouldReturnSum() throws QuantityMeasurementException {
        tonne = new QuantityMeasurement(Weight.TONNE, 1.0);
        gram = new QuantityMeasurement(Weight.GRAM, 1000.0);
        double sumOfUnits = tonne.additionOfUnits(gram);
        Assert.assertEquals(1001, sumOfUnits, 0.0);
    }

    //    UC8
    @Test
    public void givenTemperatureInCelsiusAndFahrenheit_ShouldReturnEquivalentValue() throws QuantityMeasurementException {
        fahrenheit = new QuantityMeasurement(Temperature.FAHRENHEIT, 212.0);
        celsius = new QuantityMeasurement(Temperature.CELSIUS, 100.0);
        boolean compare = fahrenheit.compare(celsius);
        Assert.assertTrue(compare);
    }
}
