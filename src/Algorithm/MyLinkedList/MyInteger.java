package Algorithm.MyLinkedList;

public class MyInteger {

    public <T extends Number> int compare(T t1){
        return 1;
    }
    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger();

        myInteger.compare( new Integer(123));
    }
}
