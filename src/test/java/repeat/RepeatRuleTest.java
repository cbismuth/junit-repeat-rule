/*
 * The MIT License (MIT)
 * Copyright (c) 2016 Christophe Bismuth
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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

    /** Tests the repetition rule when enabled. */
    @Test
    @Repeat(times = EXPECTED_COUNT_VALUE, threads = 4)
    public void testWithRepetition() {
        counter.addAndGet(1);
    }

    /** Tests the repetition rule when an exception is raised. */
    @Test(expected = IllegalArgumentException.class)
    @Repeat(times = EXPECTED_COUNT_VALUE, threads = 4)
    public void testWithException() {
        throw new IllegalArgumentException();
    }

    /** Tests the repetition rule when disabled. */
    @Test
    public void testWithoutRepetition() {
        // NOP
    }

}
