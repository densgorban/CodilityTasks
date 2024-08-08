package tasks.streams;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MainSupplier {

    public static List<Student> timeRecorder(Supplier<List<Student>> heavyOperation) {
        Instant start = Instant.now();
        List<Student> result = heavyOperation.get();
        Instant end = Instant.now();
        System.out.println("Duration: " + Duration.between(start,end));
        return result;
    }

    public static void main(String[] args) {
        Supplier<List<Student>> createGroup = () -> Arrays.asList(
                new Student(10, "Borys", Gender.MALE, 10.2f),
                new Student(10, "Denys", Gender.MALE, 8.1f),
                new Student(10, "Jane", Gender.MALE, 11.1f)
        );

        Stream<List<Student>> group = Stream.generate(createGroup);

        timeRecorder(createGroup);
    }
}
