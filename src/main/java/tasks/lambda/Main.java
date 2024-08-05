package tasks.lambda;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("red", 100f),
                new Apple("green", 200),
                new Apple("yellow", 300)
                );

        new AppleBox().printApple(apples, a-> !a.color().equals("green"));
    }


}
