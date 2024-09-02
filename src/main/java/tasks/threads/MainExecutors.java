package tasks.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MainExecutors {

    public static void main(String[] args) {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        Thread thread = threadFactory.newThread(() -> {
        });

        ThreadFactory threadFactory1 = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };

    }

}
