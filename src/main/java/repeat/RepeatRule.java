package repeat;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/** This class represents a JUnit rule to repeat JUnit test cases. */
public class RepeatRule implements TestRule {

    public Statement apply(final Statement statement, final Description description) {
        final Repeat repeat = description.getAnnotation(Repeat.class);

        final Statement result;
        if (repeat != null) {
            result = new RepeatStatement(repeat.times(),
                                         repeat.threads(), repeat.timeout(), repeat.unit(),
                                         statement);
        } else {
            result = statement;
        }

        return result;
    }

}
