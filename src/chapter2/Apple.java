package chapter2;

public class Apple {
    Integer weight;
    Color color;

    public Apple(int weight, Color color) {
        this.weight=weight;
        this.color=color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }
}
