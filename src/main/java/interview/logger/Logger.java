package interview.logger;

import java.time.Instant;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class Logger {

    private volatile boolean stopFlag = false;
    private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100, true);

    private static Logger logger;

    public static Logger logger() {
        if(logger == null)
            logger = new Logger();
        return logger;
    }

    private Logger() {
        Thread worker = new Thread( () -> {
            while(!stopFlag) {
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
        worker.setName("logger");
        worker.start();
    }

    public void stop() {
        stopFlag = true;
    }

    public synchronized void logMessage(String fileName, String message, String level) {
        String string = Instant.now().toString();
        String formattedLog = "[" + string + "] " +
                "[" + level + "] " +
                message;
        try {
            queue.put(formattedLog);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
