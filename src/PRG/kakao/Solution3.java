package PRG.kakao;

public class Solution3 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int pocket;
        Loop:
        while (true) {
            for (int i = n - 1; i >= 0; i--) {
                if (pickups[i] == 0 && deliveries[i] == 0) {
                    if (n == 1) break Loop;
                    n--;
                } else {
                    break;
                }
            }
            pocket = cap;
            for (int i = n - 1; i >= 0; i--) {
                if (deliveries[i] == 0) continue;

                if (deliveries[i] <= pocket) {
                    pocket = pocket - deliveries[i];
                    deliveries[i] = 0;
                } else if (deliveries[i] >= pocket) {
                    deliveries[i] = deliveries[i] - pocket;
                    break;
                }
            }
            pocket = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (pickups[i] == 0) continue;

                if (pickups[i] < (cap - pocket)) {
                    pocket = pocket + pickups[i];
                    pickups[i] = 0;
                } else if (pickups[i] >= (cap - pocket)) {
                    pickups[i] = pickups[i] - (cap - pocket);
                    break;
                }
            }
            answer += (n * 2);
        }

        return answer;
    }


}
