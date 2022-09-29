import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int[] copyOfA = A.clone();
        Arrays.sort(copyOfA);

        Integer[] clearA = Arrays.stream(copyOfA)
                .boxed()
                .filter( x -> x>0)
                .collect(Collectors.toSet())
                .toArray(Integer[]::new);

        int x = 0;

        while(clearA.length != x && clearA[x] - x == 1) {
            x++;
        }

        int result = x + 1;
        System.out.println("Answer is " + result);
        return result;
    }

    public static void main(String[] args) {
        solution(new int[]{1,3,5, -1, 6, 10, 4, 7, 7});
    }
}
