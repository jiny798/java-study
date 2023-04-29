package chapter2.view;

import chapter2.Ball;

import java.util.List;

public class OutputView {

    public void printList(List<Ball> list){
        for(Ball ball : list){
            System.out.println(ball.getCategory()+"-"+ ball.getCost());
        }
    }
}
