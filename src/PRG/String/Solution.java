package PRG.String;

import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (Character.isDigit(str.charAt(0))) {
                list.add(str.toLowerCase());
                continue;
            }
            if (str.length() == 1) {
                list.add(str.toUpperCase());
            } else {
                String f = str.substring(0, 1);
                String b = str.substring(1, str.length());
                list.add(f.toUpperCase() + b.toLowerCase());
            }
        }
        ArrayList<String> blankList = new ArrayList<>();
        String blank = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(" ")) {
                blank += " ";
                if (i == s.length() - 1) {
                    blankList.add(blank);
                }
            } else {
                if (!blank.equals("")) {
                    blankList.add(blank);
                }
                blank = "";
            }
        }
        int k = 0;
        String answer = "";
        if (s.charAt(0) == ' ') {
            answer += blankList.get(k++);
        }
        blankList.add("");
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
            answer += blankList.get(k++);
        }
        System.out.println(blankList.size());
        return answer;
    }
}