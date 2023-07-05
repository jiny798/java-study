package BOJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine(); // 4
        int n = Integer.parseInt(first);

        while (n-- > 0) { // 4
            String operStr = br.readLine(); // RDD
            boolean direction = true;
            boolean err = false;

            int size = Integer.parseInt(br.readLine()); // 4
            LinkedList<Integer> list = new LinkedList<>();
            String listStr = br.readLine(); // [1,2,3,4]
            String[] arrValueToken = listStr.split("\\[|,|\\]");
            for (int i = 0; i < size; i++) {
                list.add(Integer.parseInt(arrValueToken[i + 1])); // 1,2,3,4
            }

            for (int i = 0; i < operStr.length(); i++) {
                if (operStr.charAt(i) == 'R') {
                    direction = !direction;
                    continue;
                }
                if (operStr.charAt(i) == 'D') {
                    if (list.size() == 0) {
                        err = true;
                        break;
                    }
                    if (direction) {
                        list.removeFirst();
                    } else {
                        list.removeLast();
                    }
                }
            }// for
            if (err == true) {
                System.out.println("error");
            } else {
                if (direction) { // 삭제해서 넣는걸로 구현 필요
                    StringBuffer buffer = new StringBuffer("[");

                    while (list.size() > 0) {
                        buffer.append(list.removeFirst());
                        if (0 != list.size()) {
                            buffer.append(",");
                        }
                    }
                    buffer.append("]");
                    System.out.println(buffer);
                } else {
                    StringBuffer buffer = new StringBuffer("[");
                    while (list.size() > 0) {
                        buffer.append(list.removeLast());
                        if (0 != list.size()) {
                            buffer.append(",");
                        }
                    }
                    buffer.append("]");
                    System.out.println(buffer);
                }
            }

        }

    }

}
