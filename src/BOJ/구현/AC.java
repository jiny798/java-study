package BOJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();

        int n = Integer.parseInt(first);

        while (n-- > 0) {
            String cmd = br.readLine(); //RDD
            String size = br.readLine(); // 4
//            int[] arr = new int[Integer.parseInt(size)];
            ArrayList<Integer> list = new ArrayList<>();
            String arrValue = br.readLine(); //[1,2,3,4]
            String[] arrValueToken = arrValue.split("\\[|,|\\]");


            for (int i = 0; i < Integer.parseInt(size); i++) {
                list.add(Integer.parseInt(arrValueToken[i + 1])); // 1,2,3,4
            }
            try {
                startCmd(list, cmd);
                StringBuffer buffer = new StringBuffer("[");
                for (int i = 0; i < list.size(); i++) {
                    buffer.append(list.get(i));
                    if (i != list.size() - 1) {
                        buffer.append(",");
                    }
                }
                buffer.append("]");
                System.out.println(buffer);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("error");
            }

        }

    }

    public static void startCmd(List<Integer> list, String cmd) {
        for (int i = 0; i < cmd.length(); i++) {
            if (cmd.charAt(i) == 'R') {
                Collections.reverse(list);
            } else {
                //cmd.charAt(i) =='D'
                list.remove(0);

            }
        }
    }
}
