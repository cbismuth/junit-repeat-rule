package repeat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Repeat {

    int times();

    int threads() default 1;

    long timeout() default Long.MAX_VALUE;

    TimeUnit unit() default TimeUnit.MILLISECONDS;

}
