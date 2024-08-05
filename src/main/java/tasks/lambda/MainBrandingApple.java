package tasks.lambda;

import java.util.Arrays;
import java.util.List;

public class MainBrandingApple {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("red", 100f),
                new Apple("green", 200),
                new Apple("yellow", 300)
                );

        BrandingApple<Apple, BrandApple> sunflowerBranding = a -> new BrandApple(a, "sunflower");

        List<BrandApple> brandApples = new AppleBox().brandApple(apples, sunflowerBranding);
        System.out.println(brandApples);
    }

}
