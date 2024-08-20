package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HourGlass {
    public static void main(String[] args) throws IOException {
        int x = 6;
        int y = 6;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, y).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        ArrayList<Integer> results = new ArrayList<>();

        int[][] mask = {{1,1,1},{0,1,0},{1,1,1}};
        Integer[][] array = (Integer[][]) arr.stream().map(r -> r.toArray()).collect(toList()).toArray();



        IntStream.rangeClosed(0, y-3).forEach(yy -> {
            IntStream.rangeClosed(0, x-3).forEach(xx -> {



            });
        } );
    }
}
