package PRG.sort;

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] strArr = new String[numbers.length];
        int index =0;
        for (int i : numbers){
            strArr[index++] = i+"";
        }

        Arrays.sort(strArr,(s1,s2)->{
            if(!s1.equals(s2)){
                return (s2+s1).compareTo((s1+s2));
            }
                return 0;
        });
        if(strArr[0].equals("0")){ // 첫번쨰가 0이면 모든 원소가 0인 경우
            return "0";
        }
        for(String s : strArr){
            answer+=s;
        }
        return answer;
    }
}
