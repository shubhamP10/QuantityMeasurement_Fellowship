import com.bridgelabz.qualitymeasurement.services.QualityMeasurement;
import org.junit.Test;

public class QualityMeasurementTest {
    @Test
    public void givenLengthInFeet_ShouldReturnEquivalentValueInInches() {
        Double inchesForFeet = new QualityMeasurement().getInchesForFeet(2.5);
        System.out.println(inchesForFeet);
    }
}
