package PRG;

public class Solution3 {
    public int solution(String S, int[] C) {
        // S = "abccbd"  C = [0,1,2,3,4,5]
        int answer = 0;
        int c;
        while(true){
            System.out.println("d");
            if(!isDuplicateSideNum(S)){
                break;
            }

            for(int i = 0 ; i < S.length() - 1 ; i++){
                if(S.charAt(i) == ' '){
                    continue;
                }
                if(S.charAt(i) == S.charAt(i+1)){
                    if(C[i] < C[i+1]){
                        answer+=C[i];
                        System.out.println("왼더함"+C[i]);
                        S = S.replaceFirst(String.valueOf(S.charAt(i))," ");
                    }else{
                        answer+=C[i+1];
                        System.out.println("오른더함");
                        S = S.replaceFirst(String.valueOf(S.charAt(i))," ");
                    }
                }
            }
        }

        return answer;
    }

    public boolean isDuplicateSideNum(String s){
        for(int i = 0 ; i < s.length() - 1 ; i++){
            if(s.charAt(i) == ' '){
                continue;
            }
            if(s.charAt(i) == s.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution("aaaa",new int[]{3,4,5,6}));
//        String str = "123"; 12나와야함 ㄴ
//        System.out.println(str.charAt(0));
    }

}
