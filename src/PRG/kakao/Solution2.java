package PRG.kakao;

public class Solution2 {
    static int plusService =0;
    static int feeSum = 0;
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
            for(int i=0 ; i < users.length ; i++){
                int userWantRatio = users[i][0]; // 이 할인율 이상만 구입
                int userLimitFee = users[i][1]; // 이 금액 이상이면 서비스 가입

                //todo : 이모티콘을 구입할지, 서비스 가입할지 등 결정

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
