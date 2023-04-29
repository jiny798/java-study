package chapter2;

import chapter2.Predicate.BallHighPricePredicate;
import chapter2.Predicate.BallPredicate;
import chapter2.Predicate.BallSoccerCategoryPredicate;
import chapter2.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ChapterMain2 {

    public static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        // * 동적 파라미터화 + 람다를 사용하여 코드 줄이기
        //인벤토리를 생성한다
        List<Ball> ballList = Arrays.asList(new Ball(1000, Category.축구공),
                                              new Ball(3000, Category.축구공),
                                              new Ball(2000, Category.축구공),
                                              new Ball(20000,Category.배구공));

        List<Ball> result = filterSoccerBalls(ballList);
//        System.out.println("고전적 방식");
//        outputView.printList(result);

        //1. Predicate 직접 전달하는 방법
        List<Ball> SoccerBalls = filterBalls(ballList,new BallSoccerCategoryPredicate());
        outputView.printList(SoccerBalls);
        List<Ball> heavyBalls = filterBalls(ballList,new BallHighPricePredicate());
        System.out.println("Predicate 직접 전달하는 방법");
        outputView.printList(heavyBalls);

        //2. 익명함수 사용하는 방법
        //ApplePredicate의 test(Apple apple)을 구현하다
        List<Ball> greenBalls = filterBalls(ballList,new BallPredicate(){
            @Override
            public boolean test(Ball ball) {
                return Category.축구공.equals(ball.getCategory());
            }
        });

        //3. 람다 표현식 사용, 인자에 드가는 구현체와 오버라이드 해야하는 메소드를 대신 작성해준다.
        // ApplePredicate의 test(Apple apple)을 구현하는 부분만 최소화, new ApplePredicate(), test() 이름은 하나로 정해져있다.
        List<Ball> soccerBalls = filterBalls(ballList,(Ball ball) -> Category.축구공.equals(ball.getCategory()));

        //4. 람다 표현식 사용 (List 형식으로 추상화)
        List<Ball> filterList = filter(ballList,(Ball ball) -> Category.축구공.equals(ball.getCategory()));


        //*Comparator로 정렬하기 - 코드 전달
        ballList.sort(new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.getCost().compareTo(o2.getCost());
            }
        });

        //Comparator 람다로 사용 - 코드 전달
        ballList.sort((Ball o1, Ball o2) -> o2.getCost().compareTo(o1.getCost()));
//        outputView.printList(inventory);

        //Runnable로 코드 블록 실행하기 - void run()을 가지는 Runnable 인터페이스
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("스레드 생성자에 코드 전달 가능");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("스레드 생성자에 코드 전달 가능 - 람다사용하면 코드가 짧아진다"));
        

    }

    public static List<Ball> filterSoccerBalls(List<Ball> ballList){
        List<Ball> result = new ArrayList<>();
        for(Ball ball : ballList){
            if(Category.축구공.equals(ball.getCategory())){
                result.add(ball);
            }
        }
        return result;
    }


    public static List<Ball> filterBalls(List<Ball> inventory, BallPredicate p){
        List<Ball> result = new ArrayList<>();
        for (Ball ball : inventory){
            if(p.test(ball)){
                result.add(ball);
            }
        }
        return result;
    }

    //리스트 형식 추상화
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if (p.test(e)){
                result.add(e);
            }
        }
        return result;
    }


}
