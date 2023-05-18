package PRG.kakao;

public class Solution2 {
    static int Result_plusService = 0;
    static int Result_feeSum = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        //[[40, 10000], [25, 10000]]  비율 가격 , 	[7000, 9000]   이모티콘 가격,

        int userCount = users.length;
        int[] emo_discount = new int[emoticons.length];

        BT(0, users, emoticons, emo_discount);

        int[] answer = new int[2];
        answer[0] = Result_plusService;
        answer[1] = Result_feeSum;
        return answer; // [1, 5400]
    }

    public void BT(int index, int[][] users, int[] emoticons, int[] emo_discount) {
        if (index == emoticons.length) { //이모티콘 별 할인 설정 완료
            //users = [[40, 10000], [25, 10000]]  비율 가격 ,
            int feeSum = 0;
            int serviceCount = 0;
            for (int i = 0; i < users.length; i++) {
                int userWantRatio = users[i][0]; // 이 할인율 이상만 구입
                int userLimitFee = users[i][1]; // 이 금액 이상이면 서비스 가입
                int fee = 0;
                //이모티콘별 할인율 체크 ex. 10 10 10 10
                for (int j = 0; j < emo_discount.length; j++) {
                    if (userWantRatio <= emo_discount[j]) { // 유저가 원하는 할인율 이상이면 가격 합산
                        fee += (emoticons[j] * (100 - emo_discount[j]) / 100);
                    }
                }
                //이모티콘 구매의 합이 일정 가격 이상이 된다면, 모두 취소하고 플러스 서비스에 가입합니다.
                if (fee >= userLimitFee) {
                    // System.out.println(fee+" "+userLimitFee);
                    fee = 0;
                    serviceCount++;
                } else {
                    feeSum += fee;

                }
            }
            if (Result_plusService < serviceCount) {
                Result_plusService = serviceCount;
                Result_feeSum = feeSum;
                return;
            }
            if (Result_plusService == serviceCount && Result_feeSum <= feeSum) {
                Result_plusService = serviceCount;
                Result_feeSum = feeSum;
                return;
            }
            return;
        }

        //for 문으로 할인율 10~40퍼 확인
        for (int i = 10; i <= 40; i += 10) {
            emo_discount[index] = i; //이모티콘 별 할인율 저장
            BT(index + 1, users, emoticons, emo_discount);
        }

    }

}
