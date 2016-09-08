package repeat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/** Annotation to repeat JUnit test cases. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Repeat {

    /**
     * The number of times to repeat a test.
     *
     * @return the number of times to repeat a test
     */
    int times();

    /**
     * The number of threads the execute a test in parallel.
     *
     * @return the number of threads the execute a test in parallel
     */
    int threads() default 1;

    /**
     * The timeout after with the executor service will be forced to shutdown.
     *
     * @return the timeout after with the executor service will be forced to shutdown
     */
    long timeout() default Long.MAX_VALUE;

    /**
     * The timeout time unit.
     *
     * @return the timeout time unit
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;

}
