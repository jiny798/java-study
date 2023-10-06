package Algorithm;

public class Test3 {
    public int solution(int[] schedules) {
        int answer = 0;

        int size = schedules.length;
        int[] DP = new int[size]; //

        DP[0] = schedules[0];
        DP[1] = schedules[1];

        for(int i = 2 ; i < size ; i++){
            DP[i] = Math.max(DP[i-1], DP[i-2]+schedules[i]);

        }
        answer = DP[size-1];
        return answer;
    }

    public static void main(String[] args) {
        Test3 test = new Test3();
        System.out.println(test.solution(new int[]{30,30,60,90,60,15,15,60}));
    }
}
