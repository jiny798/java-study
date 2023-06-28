package PRG;

public class Solution {
    public int solution(String S) {
        String firstStr = S;
        int answer = 0;
        while (true){
            if(checkSame(S)){
                answer++;
            }
            S = changeStr(S);
            if(firstStr.equals(S)){
                break;
            }
        }
        return answer;
    }

    public String changeStr(String s){
        String start = s.substring(0,1);
        String rest = s.substring(1,s.length());

        return rest+start;
    }

    public boolean checkSame(String s){
        String start = s.substring(0,1);
        String last = s.substring(s.length()-1,s.length());
        return start.equals(last);
    }


}
