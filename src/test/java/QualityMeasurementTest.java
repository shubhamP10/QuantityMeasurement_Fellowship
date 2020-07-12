import com.bridgelabz.qualitymeasurement.services.QualityMeasurement;
import org.junit.Test;

public class QualityMeasurementTest {
    @Test
    public void givenLengthInFeet_ShouldReturnEquivalentValueInInches() {
        double inchesForFeet = new QualityMeasurement().getInchesForFeet(1);
        double feetForInches = new QualityMeasurement().getFeetForInches(12);
        System.out.println(inchesForFeet);
        System.out.println(feetForInches);
    }
}
