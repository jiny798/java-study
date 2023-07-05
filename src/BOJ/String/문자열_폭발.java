package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열_폭발 { // 스택 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer(br.readLine()); // 12ab112ab
        String bomb = br.readLine(); // 12ab

        int bombSize = bomb.length();

        char lastStr = bomb.charAt(bomb.length() - 1);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i); // 1

            stack.add(s);
            if (s == lastStr && stack.size() >= bombSize) {
                int stackSize = stack.size(); //
                String tempStr = "";
                stackSize -= 1;
                for (int j = 0; j < bombSize; j++) {
                    tempStr = stack.get(stackSize--) + tempStr;
                }

                if (tempStr.equals(bomb)) {
                    for (int j = 0; j < bombSize; j++) {
                        stack.pop();
                    }
                }
            }
        }// for end

        StringBuilder sb = new StringBuilder();

        int s = stack.size();
        for (int j = 0; j < s; j++) {
            sb.append( stack.pop()) ;
        }

        if (s == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.reverse());
        }

    }
}
