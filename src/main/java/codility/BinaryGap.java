import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryGap {

    public static int solution(int N) {
        // write your code in Java SE 8
        String s = Integer.toBinaryString(N);
        System.out.println("Answer is " + s);
        List<Integer> gaps = new ArrayList<>();
        int prviousIndex = 0;
        do {
            int currentIndex = s.indexOf("1", prviousIndex+1);
            System.out.println("index " + currentIndex);
            if(currentIndex == -1) break;
            int gap = currentIndex - prviousIndex;
            gaps.add(gap);
            System.out.println("gap " + gap);
            prviousIndex=currentIndex;
        } while(true);
        System.out.println("Indexes " + gaps.toString());
        if(gaps.size() == 0) return 0;
        Integer maxGap = Collections.max(gaps);
        return maxGap;
    }

    public static int solution2(int N) {
        // write your code in Java SE 8
        String s = Integer.toBinaryString(N);

        String[] split = s.split("\\w10+1");
        return Stream.of(split).mapToInt(String::length).max().orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(solution(32));
        System.out.println(solution2(32));
    }
}
