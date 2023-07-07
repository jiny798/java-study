package PRG.kakao;

public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliverBag = 0;
        int pickUpBag = 0;
        long answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while (deliverBag < deliveries[i] || pickUpBag < pickups[i]) {
                    cnt++;
                    deliverBag += cap;
                    pickUpBag += cap;
                }
                deliverBag -= deliveries[i];
                pickUpBag -= pickups[i];
                answer += (i + 1) * cnt * 2;
            }
        }
        return answer;
    }
}
