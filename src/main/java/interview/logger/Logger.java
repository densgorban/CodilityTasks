package interview.logger;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.lang.Thread.sleep;

public class Logger implements AutoCloseable {

    private volatile boolean stopFlag = false;

    ConcurrentMap<String, Queue<String>> storage = new ConcurrentHashMap<>();
    private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100, true);

    private static Logger logger;

    public static Logger logger() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    private Logger() {
        Thread worker = new Thread(() -> {
            while (!stopFlag) {
                try {
                    do {
                        String message = queue.take();
                        System.out.println(message);
                    } while (queue.isEmpty());
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        worker.setName("custom_logger");
        worker.start();
    }

    public void stop() {
        stopFlag = true;
    }

    public synchronized void logMessage(String fileName, String message, String level) {
        storage.putIfAbsent(fileName, new LinkedList<>());
        storage.get(fileName).add(String.format("[%s][%s] %s", Instant.now().toString(), level, message));
    }

    @Override
    public void close() throws Exception {

    }
}
