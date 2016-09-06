package repeat;

import org.junit.runners.model.Statement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class RepeatStatement extends Statement {

    private final int times;

    private final int threads;
    private final long timeout;
    private final TimeUnit unit;

    private final Statement statement;

    public RepeatStatement(final int times,
                           final int threads, final long timeout, final TimeUnit unit,
                           final Statement statement) {
        this.times = times;

        this.threads = threads;
        this.timeout = timeout;
        this.unit = unit;

        this.statement = statement;
    }

    @Override
    public void evaluate() throws Throwable {
        final ExecutorService executorService = newFixedThreadPool(threads);

        for (int i = 0; i < times; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        statement.evaluate();
                    } catch (Throwable throwable) {
                        throw new RuntimeException(throwable);
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(timeout, unit);
        executorService.shutdownNow();
    }

}
