package Algorithm;

public class test {


    public int solution(String s, int N) {
        int answer = 0;

        for (int i = 0; i <= s.length() - N; i++) {
            String fragStr = s.substring(i, i + N);
            if (checkPenDigital(fragStr,N)){
                int fragInt = Integer.parseInt(fragStr);
                if (answer < fragInt){
                    answer = fragInt;
                }
            }
        }

        if (answer ==0){
            return -1;
        }
        return answer;
    }

    public boolean checkPenDigital(String str, int N) {
        for (int i = 1; i <= N; i++) {
            if(!str.contains(String.valueOf(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test t = new test();

        System.out.println(t.solution("1451232125",2));


    }


}
