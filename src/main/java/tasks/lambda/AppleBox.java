package tasks.lambda;

import java.util.ArrayList;
import java.util.List;

public class AppleBox {

    public void printApple(List<Apple> apples, CheckApple filter) {
        for (Apple a: apples) {
            if(filter.check(a))
                System.out.println(a);
        }
    }

    public List<BrandApple> brandApple(List<Apple> apples, BrandingApple branding) {

        ArrayList<BrandApple> brandApples = new ArrayList<>();
        for (Apple a: apples){
            BrandApple brandedApple = (BrandApple) branding.convert(a);
            brandApples.add(brandedApple);
        }

        return brandApples;
    }

}
