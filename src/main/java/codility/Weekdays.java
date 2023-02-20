import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Weekdays {


    public static String solution(String S, int K) {
        List<String> weekdays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        // write your code in Java SE 11
        int weekdayGap = K % 7;

        int currentWeekday = weekdays.indexOf(S);

        int finalDay = (currentWeekday +weekdayGap) % 7;

        return weekdays.get(finalDay);

    }

    public static void main(String[] args) {
        System.out.println(solution("Wed", 2));
    }
}
