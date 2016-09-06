package repeat;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.assertEquals;

public class RepeatRuleTest {

    @Rule
    public RepeatRule rule = new RepeatRule();

    private static final AtomicLong counter = new AtomicLong(0);

    private static final int EXPECTED_COUNT_VALUE = 10000;

    @AfterClass
    public static void afterClass() {
        final long actualCountValue = counter.longValue();

        assertEquals(EXPECTED_COUNT_VALUE, actualCountValue);
    }

    @Test
    @Repeat(times = EXPECTED_COUNT_VALUE, threads = 4)
    public void testRepetition() {
        counter.addAndGet(1);
    }

}
