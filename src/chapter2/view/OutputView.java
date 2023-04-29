package chapter2.view;

import chapter2.Apple;

import java.util.List;

public class OutputView {

    public void printList(List<Apple> list){
        for(Apple apple : list){
            System.out.println(apple.getColor()+"-"+apple.getWeight());
        }
    }
}
