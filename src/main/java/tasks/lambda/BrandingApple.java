package tasks.lambda;
@FunctionalInterface
public interface BrandingApple<T,V> {

    V convert(T t);

    static <T> boolean isNotNull(T t){
        return t != null;
    }

    default void writeToConsole(T t) {
        System.out.println("Current Object" + t.toString());
    }

    boolean equals(Object obj);
}
