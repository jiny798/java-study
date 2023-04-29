package chapter2.Predicate;

import chapter2.Apple;
import chapter2.Color;

import static chapter2.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
