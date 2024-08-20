package interview.logger;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LoggerTest {

    @Test
    public void loggerWorkerCreatedTest(@TempDir Path dir) throws IOException {
        System.out.println(dir.getFileName());
        String path = dir.toFile().getPath();
        System.out.println(path);

        File file = new File(path + "/testfile.log" );
        file.createNewFile();
        Logger.logger().logMessage("testfile.log", "test message", "INFO");
        System.out.println(file.exists());
    }

    @Test
    public void logFileIsCreated() {
        throw new NotImplementedException("implement test");
    }
    @Test
    public void logsAreSaved() {
        throw new NotImplementedException("implement test");
    }


}
