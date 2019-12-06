package joroutine;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class PoolDispatcher extends Dispatcher {
    private final ExecutorService executor;

    public PoolDispatcher(String name, ExecutorService executor) {
        super(name);
        this.executor = executor;
    }

    @Override
    protected void doDispatch(Continuation continuation) {
        executor.submit((Callable<Object>) continuation::run);
    }
}