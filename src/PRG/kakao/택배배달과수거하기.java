package PRG.kakao;

public class 택배배달과수거하기 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {

		int deliveryBag = 0; // 용량 초기화
		int pickupBag = 0; // 용량 초기화
		long answer = 0;
		for (int i = n-1; i >= 0; i--) {
			// 남은 배달 / 남은 수거가 있는지 횟수 체크
			long cnt = 0;
			while (deliveries[i] > deliveryBag || pickups[i] > pickupBag) {
				cnt++;
				deliveryBag += cap;
				pickupBag += cap;
			}

			deliveryBag -= deliveries[i]; // 3
			pickupBag -= pickups[i];

			answer += (i+1) * cnt * 2;

		}

		return answer;
	}
}
