import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class FirstUnique {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int[] copyOfA = A.clone();

        LinkedList<Integer> clearA = new LinkedList<Integer>( Arrays.stream(copyOfA)
                .boxed()
                .collect(Collectors.toList()));
        int result = -1;
        do {
            if(clearA.isEmpty()) break;
            Integer firstElement = clearA.removeFirst();
            if(!clearA.contains(firstElement)) {
                result = firstElement;
                break;
            }
            clearA.removeAll(Collections.singleton(firstElement));
        } while(true);

        System.out.println("Answer is " + result);
        return result;
    }

    public static void main(String[] args) {
        solution(new int[]{1,1,1,3,2,5, -1, 6, 10, 4, 7, 7, 1});
    }
}
