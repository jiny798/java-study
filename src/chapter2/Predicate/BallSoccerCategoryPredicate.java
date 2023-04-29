package chapter2.Predicate;

import chapter2.Ball;
import chapter2.Category;


public class BallSoccerCategoryPredicate implements BallPredicate {
    @Override
    public boolean test(Ball ball) {
        return Category.축구공.equals(ball.getCategory());
    }
}
