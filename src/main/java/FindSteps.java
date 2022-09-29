import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class FindSteps {

    public static int solution(int[] A) {
        //find evarage
        int avg = Math.round(Arrays.stream(A).reduce(0, (a, b) -> a + b) / A.length);
        System.out.println("Avarage " + avg);
        //find number of steps
        AtomicInteger result = new AtomicInteger();
        Arrays.stream(A).forEach(a -> result.set(+Math.abs(avg - a)));
        for (int i = 0; i < 6; i++) {
            
        }
        return 0;
    }

    public static void main(String[] args) {
        solution(new int[]{1,3,5, -2, 6, 10, 4, 7, 7});
    }
}
