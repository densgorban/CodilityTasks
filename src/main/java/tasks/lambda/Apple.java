package tasks.lambda;

class Apple {

    private String color;
    private float weight;

    public Apple(String color, float weight) {
        this.color = color;
        this.weight = weight;
    }

    public String color() {
        return color;
    }
    public float weight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

