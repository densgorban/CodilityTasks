package tasks.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentsForumMain {

    public static void main(String[] args) {
        Predicate<Student> nameFilter = s -> s.getName().startsWith("Boris");
        Predicate<Student> genderFilter = s -> s.getGender().equals(Gender.MALE);
        Predicate<Student> averageScoreFilter = s -> s.getAverageScore() >= 10;

        List<Student> students = Arrays.asList(
                new Student(10, "", Gender.MALE, 11.1f),
                new Student(20, "", Gender.MALE, 9.3f),
                new Student(30, "", Gender.FEMALE, 11.9f),
                new Student(40, "", Gender.FEMALE, 10.0f)
        );

        List<Student> bestStudents = students.stream().filter(averageScoreFilter).toList();
        System.out.println(bestStudents);

    }
}
