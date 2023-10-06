package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Test4 {
    public int solution(int[] prices, int k) {
        int answer = 0;

        for (int i = 0; i < prices.length - k; i++) {
            int money = -(prices[i] * k);

            Integer[] arr = new Integer[prices.length - (i + 1)];


            int index = 0;
            for (int j = i + 1; j < prices.length; j++) {
                arr[index++] = prices[j];
            }

            Arrays.sort(arr, Comparator.reverseOrder());

            int sell = 0;
            for (int m = 0; m < k; m++) {
                sell += arr[m];
            }

            money = money + sell;
            if (answer < money) {
                answer = money;
            }
        }

        if (answer == 0) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Test4 test = new Test4();

        System.out.println(test.solution(new int[]{10,7,8,5,8,7,6,2,9},3));
    }
}
