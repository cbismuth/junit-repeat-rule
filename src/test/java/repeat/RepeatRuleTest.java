package repeat;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.assertEquals;

/** A class to test the JUnit repetition rule. */
public class RepeatRuleTest {

    /** The JUnit repetition rule. */
    @Rule
    public RepeatRule rule = new RepeatRule();

    private static final AtomicLong counter = new AtomicLong(0);

    private static final int EXPECTED_COUNT_VALUE = 10000;

    /** Asserts the number of times the annotated test was repeated. */
    @AfterClass
    public static void afterClass() {
        final long actualCountValue = counter.longValue();

        assertEquals(EXPECTED_COUNT_VALUE, actualCountValue);
    }

    /** Tests the repetition rule. */
    @Test
    @Repeat(times = EXPECTED_COUNT_VALUE, threads = 4)
    public void testRepetition() {
        counter.addAndGet(1);
    }

}
