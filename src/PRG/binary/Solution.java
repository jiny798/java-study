package PRG.binary;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long minTime = 1;
        Arrays.sort(times);
        long maxTime = (long) n * times[times.length - 1]; // 60

        while (minTime <= maxTime) {
            long midTime = (minTime + maxTime) / 2;
            long possibleCheck = 0;

            for (int i = 0; i < times.length; i++) {
                possibleCheck += (midTime / times[i]); // 30 / 7 , 30/10  => 4+3
            }

            // if (n==possibleCheck){
            //    maxTime = midTime-1;
            //    answer=midTime;
            //    continue;
            // }
            if (n > possibleCheck) {
                minTime = midTime + 1;
                continue;
            }
            if (n <= possibleCheck) {
                maxTime = midTime - 1;
                answer = midTime;
                continue;
            }
        }
        return answer;
    }
}
