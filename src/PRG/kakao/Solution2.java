package PRG.kakao;

public class Solution2 {
    static int Result_plusService = Integer.MIN_VALUE;
    static int Result_feeSum = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        //[[40, 10000], [25, 10000]]  비율 가격 , 	[7000, 9000]   이모티콘 가격,

        int userCount = users.length;
        int[] emo_discount = new int[emoticons.length];

        BT(0,users,emoticons,emo_discount);

        return null; // [1, 5400]
    }

    public void BT(int index,int[][] users,int[] emoticons,int[] emo_discount){

        if(index == emoticons.length){ //이모티콘 별 할인 설정 완료
            //users = [[40, 10000], [25, 10000]]  비율 가격 ,
            int feeSum =0;
            int serviceCount = 0;
            for(int i=0 ; i < users.length ; i++){ // 유저수마다 반복
                int userWantRatio = users[i][0]; // 이 할인율 이상만 구입
                int userLimitFee = users[i][1]; // 이 금액 이상이면 서비스 가입

                //todo : 이모티콘을 구입할지, 서비스 가입할지 등 결정
                for(int j=0;j<emo_discount.length;j++){
                    int emoDiscount = emo_discount[j];
                    if( userWantRatio >= emoDiscount){
                        feeSum+= emoticons[j]; //이모티콘 가격 합산
                    }
                }
                //이모티콘 구매의 합이 일정 가격 이상이 된다면, 모두 취소하고 플러스 서비스에 가입합니다.
                if(feeSum >= userLimitFee){
                    feeSum=0;
                    serviceCount++;
                }
            }


            return;
        }

        //for 문으로 할인율 10~40퍼 확인
        for(int i=10 ; i<=40 ; i+=10){
            emo_discount[index] = i; //이모티콘 별 할인율 저장
            BT(index+1,users,emoticons,emo_discount);
        }


    }

}
