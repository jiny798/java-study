package chapter2.Predicate;

import chapter2.Apple;

public class AppleHeavyWightPredicate implements  ApplePredicate{
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}
