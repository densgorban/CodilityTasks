package tasks.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Filters {
    // color == "green"
    
    public static List<Apple> filterByColor(List<Apple> apples) {
       return  apples.stream().filter(x -> x.getColor().equals("green")).collect(Collectors.toList());
    }

    //group by color -> Map<Color, List<Apples>>
    public static Map<String, List<Apple>> groupByColor(List<Apple> apples) {
        HashMap<String, List<Apple>> result = new HashMap<>();
        for (Apple a: apples) {
            result.putIfAbsent(a.getColor(), new ArrayList<>()).add(a);
        }
        return result;
    }

    //max weight
    public static Optional<Apple> maxWeight(List<Apple> apples) {
        return apples.stream().max((o1, o2) -> (int) (o1.getWeight() - o2.getWeight()));
    }

    //TODO implement a method for filtering the list of T by an arbitrary filter
    public static <T> List<T> filter(List<T> entities, Predicate<T> filter) {
        return entities.stream().filter(filter).collect(Collectors.toList());
    }
}