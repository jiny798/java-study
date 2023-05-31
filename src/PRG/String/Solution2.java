package PRG.String;

//https://school.programmers.co.kr/learn/courses/30/lessons/12951
//JadenCase 문자열 만들기
public class Solution2 {
    public String solution(String s) {
        String answer = "";
        boolean isFirstChar = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += " ";
                isFirstChar = true;
            } else {
                if (isFirstChar) {
                    answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
                } else {
                    answer += String.valueOf(Character.toLowerCase(s.charAt(i)));
                }
                isFirstChar = false;
            }
        }
        return answer;
    }
}
