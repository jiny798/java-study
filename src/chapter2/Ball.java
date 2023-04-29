package chapter2;

public class Ball {
    Integer cost;
    Category category;
    public Ball(Integer cost, Category name) {
        this.cost=cost;
        this.category=name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Category getCategory() {
        return category;
    }
    public Integer getCost() {
        return cost;
    }
}
