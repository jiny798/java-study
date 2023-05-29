package PRG.kakao;

import java.util.Arrays;

/*
 * 파일명 정렬 https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */
public class Solution4 {
    public String[] solution(String[] files) {
        String[][] dividedStr = new String[files.length][3];

        for (int i = 0; i < files.length; i++) {
            String text = files[i]; // fil010d.txt
            int first;
            for (first = 0; first < text.length(); first++) {
                if (Character.isDigit(text.charAt(first))) {
                    // 숫자면 빠져나간다
                    dividedStr[i][0] = text.substring(0, first);
                    break;
                }
            }
            //foo01bar020.zip
            int second;
            for (second = first; second < text.length(); second++) {
                if (!Character.isDigit(text.charAt(second))) {
                    // 숫자가 아니면 빠져나온다
                    break;
                }
            }

            if (second == text.length()) {
                dividedStr[i][1] = text.substring(first, second);
                dividedStr[i][2] = ""; //안적으면 null 드간다.

            } else {
                dividedStr[i][1] = text.substring(first, second);
                dividedStr[i][2] = text.substring(second, text.length());
            }

        }
        Arrays.sort(dividedStr, (o1, o2) -> {
            if (!o1[0].toLowerCase().equals(o2[0].toLowerCase())) {
                return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
            } else {
                if (!Integer.valueOf(o1[1]).equals(Integer.valueOf(o2[1]))) {
                    return Integer.valueOf(o1[1]).compareTo(Integer.valueOf(o2[1]));
                } else {
                    return 0;
                }
            }
        });
        String[] answer = new String[files.length];
        for (int i = 0; i < dividedStr.length; i++) {
            answer[i] = dividedStr[i][0] + dividedStr[i][1] + dividedStr[i][2];
        }

        return answer;
    }
}
