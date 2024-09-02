package interview.logger;

import org.apache.commons.lang3.NotImplementedException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import org.hamcrest.Matchers;


import static interview.logger.Logger.logger;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoggerTest {

    @TempDir
    static Path tempDir;
    static Path tempLogFile;


    @BeforeAll
    public static void init() throws IOException {

    }

    @Test
    public void loggerWorkerIsCreatedTest() throws IOException {

        logger();

        Thread.currentThread().getThreadGroup();
        Set<String> threadNames = Thread.getAllStackTraces()
                .keySet()
                .stream()
                .map(Thread::getName).collect(toSet());
        assertThat(threadNames, Matchers.hasItem("custom_logger"));
    }

    @Test
    public void logFileIsCreated() {
        logger().logMessage("logfile.txt","message", "INFO");

    }

    @Test
    public void logsAreSaved() {
        throw new NotImplementedException("implement test");
    }


}
