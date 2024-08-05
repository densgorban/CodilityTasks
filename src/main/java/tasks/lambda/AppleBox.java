package tasks.lambda;

import java.util.List;

public class AppleBox {

    public void printApple(List<Apple> apples, CheckApple filter) {
        for (Apple a: apples) {
            if(filter.check(a))
                System.out.println(a);
        }
    }

}
