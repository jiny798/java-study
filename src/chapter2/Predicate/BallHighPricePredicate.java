package chapter2.Predicate;

import chapter2.Ball;

public class BallHighPricePredicate implements BallPredicate {
    public boolean test(Ball ball){
        return ball.getCost() > 10000;
    }
}
