package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ChapterMain3 {
    public static void main(String[] args) throws IOException {

        String result = processFile((BufferedReader br) -> br.readLine());
        String result2 = processFile((BufferedReader br) -> br.readLine() +br.readLine());


        //함수형 인터페이스의 추상 메서드는 람다 표현식의 시그니처를 묘사한다.
        // 함수 디스크립터라고 한다.

        List<String> list = List.of("박진영","김진영","이진영");
//        List<String> stringList = filter(list,s -> s.equals("박진영"));
//        List<String> stringList2 = filter(list,(String s) -> s.equals("박진영"));
//
//
//        for (String str : stringList){
//            System.out.println(str);
//        }
//        forEach(list,s-> System.out.println(s));

        List<String> stringList = map(list,s -> s.substring(0,1) );
        forEach(stringList,s-> System.out.println(s));

    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T t: list){
            result.add(f.apply(t));
        }
        return result;
    }

    //Consumer<T>
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T t: list){
            c.accept(t);
        }
    }

    //Predicate
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T t : list){
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }


     // 2. 함수형 인터페이스를 이용해서 동작 전달
     public static String processFile(BufferedReaderProcessor p) throws IOException{
         try(BufferedReader br = new BufferedReader(new FileReader("src/chapter3/data.txt"))){
             return p.process(br);
         }
     }


}
