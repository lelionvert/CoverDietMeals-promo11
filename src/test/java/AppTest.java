import fr.lacombe.CoversCounter;
import fr.lacombe.Participant;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

public class AppTest {

    @Test
    public void testEnvironment() {
        Assertions.assertThat(true).isTrue();
    }

    @Test
    @Ignore
    public void scenario1() {

        Participant bruno = new Participant("Pescatarian");
        Assertions.assertThat(new CoversCounter().getPescatarianCovers(bruno)).isEqualTo(2);
    }
}
