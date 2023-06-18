package BOJ.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분수열의_합 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();

        String[] tokens = line1.split(" ");
        int N = Integer.parseInt(tokens[0]);
        int wantResult = Integer.parseInt(tokens[1]);

        int[] arr = new int[N];

        String line2 = br.readLine();
        tokens = line2.split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        // N=3 일때 1 , 10, 11,
        for (int i = 1; i < (1 << N); i++) {
            int sum = 0;
            for (int k = 0; k < N; k++) {
                if ((i & (1 << k)) > 0) {
                    sum += arr[k];
                }
            }
            if (sum == wantResult) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
