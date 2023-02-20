package hackerrank;

import java.io.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            String result = "";

            if( i%3 == 0) result += "Fizz";
            if( i%5 == 0) result += "Buzz";
            if (result.isEmpty()) result = "" + i;

            System.out.println(result);

        }


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.fizzBuzz(n);

        bufferedReader.close();
    }
}
