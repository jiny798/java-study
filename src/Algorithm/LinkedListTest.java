package Algorithm;

import java.util.LinkedList;
import java.util.Stack;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(0,5);
        list.addFirst(1);
        list.addLast(15);



        list.removeFirst(); // removeLast()
        
        printList(list);


        Stack<Integer> st = new Stack<>();
        st.add(10);
        st.add(20);
        System.out.println(st.get(0));
        System.out.println(st.get(1));
    }

    public static void printList(LinkedList<Integer> list){
        for (Integer i : list){
            System.out.println(i);
        }
    }
}
