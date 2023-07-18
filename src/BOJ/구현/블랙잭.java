package BOJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class 블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] arr = str.split(" ");

        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        String str2 = br.readLine();

        String[] arr2 = str2.split(" ");

        int[] intArr = Stream.of(arr2).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = intArr[i]+ intArr[j] + intArr[k];
                    if ( sum> max && sum <= M) {
                        max = sum;
                    }


                }
            }
        }
        System.out.println(max);
    }
}
