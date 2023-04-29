package chapter2;

import chapter2.Predicate.AppleGreenColorPredicate;
import chapter2.Predicate.AppleHeavyWightPredicate;
import chapter2.Predicate.ApplePredicate;
import chapter2.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static chapter2.Color.GREEN;
import static chapter2.Color.RED;

public class ChapterMain2 {

    public static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        // * 동적 파라미터화 + 람다를 사용하여 코드 줄이기
        //인벤토리를 생성한다
        List<Apple> inventory = Arrays.asList(new Apple(80, GREEN),
                                              new Apple(155, GREEN),
                                              new Apple(120,RED));

        //1. Predicate 직접 전달하는 방법
        List<Apple> heavyApples = filterApples(inventory,new AppleHeavyWightPredicate());

        //2. 익명함수 사용하는 방법
        //ApplePredicate의 test(Apple apple)을 구현하다
        List<Apple> greenApples = filterApples(inventory,new ApplePredicate(){ 
            @Override
            public boolean test(Apple apple) {
                return GREEN.equals(apple.getColor());
            }
        });

        //3. 람다 표현식 사용, 인자에 드가는 구현체와 오버라이드 해야하는 메소드를 대신 작성해준다.
        // ApplePredicate의 test(Apple apple)을 구현하는 부분만 최소화, new ApplePredicate(), test() 이름은 하나로 정해져있다.
        List<Apple> redApples = filterApples(inventory,(Apple apple) -> RED.equals(apple.getColor()));

        //4. 람다 표현식 사용 (List 형식으로 추상화)
        List<Apple> redApples3 = filter(inventory,(Apple apple) -> RED.equals(apple.getColor()));


        //*Comparator로 정렬하기 - 코드 전달
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        //Comparator 람다로 사용 - 코드 전달
        inventory.sort((Apple o1,Apple o2) -> o2.getWeight().compareTo(o1.getWeight()));
        outputView.printList(inventory);

        //Runnable로 코드 블록 실행하기 - void run()을 가지는 Runnable 인터페이스
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("스레드 생성자에 코드 전달 가능");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("스레드 생성자에 코드 전달 가능 - 람다사용하면 코드가 짧아진다"));
        

    }


    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
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
