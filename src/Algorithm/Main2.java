package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            BT(i, list, arr);
            list.remove(list.size() - 1);
        }

        List<String> menu = Arrays.asList("a","b");
        Stream<String> menuS = menu.stream();
    }

    public static void BT(int index, List<Integer> list, int[] arr) {
        if (list.size() == 3) {
            for (int k = 0; k < 3; k++) {
                System.out.print(list.get(k) + " ");
            }
            System.out.println();
            return;
        }


        for (int i = index + 1; i < arr.length; i++) {
            list.add(arr[i]);
            BT(i, list, arr);
            list.remove(list.size() - 1);
        }
    }
}
