package Personal;

public class Main {
    public static void main(String[] args) {
        String str = "a";
        str = add(str);

        System.out.println(str);

    }

    public static String add(String str){
        str = str + "1";
        return str;
    }

}
