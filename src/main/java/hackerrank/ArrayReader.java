package hackerrank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
//        System.out.println(line);
        int n = Integer.parseInt(line);
        int[] a = new int[n];
        IntStream.rangeClosed(0, n - 1).forEach(i -> {
            String nextLine = scanner.nextLine();
            System.out.println("'" + nextLine + "'");
            a[i] = Integer.parseInt(nextLine);
        });
        Arrays.stream(a).forEach(System.out::println);
    }
}
