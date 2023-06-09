package PRG.Gready;

import java.util.HashMap;
import java.util.Map;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {

        Map<Integer, Integer> studentMap = new HashMap<>();
        // 학생번호 : 체육복 수

        for (int i = 1; i <= n; i++) {
            studentMap.put(i, 1);
            //일단 학생들 체육복 한개씩 지급
        }

        for (int i = 0; i < lost.length; i++) {
            studentMap.put(lost[i], studentMap.get(lost[i]) - 1);
            //lost : 체육복 잃어버린 애들은 하나씩 감소
        }

        for (int i = 0; i < reserve.length; i++) {
            studentMap.put(reserve[i], studentMap.get(reserve[i]) + 1);
            //여분 가져온 애들 하나씩 추가
        }
        // 1번:2개 , 2:1개 , 3번 : 0개

        studentMap.put(0,0);
        studentMap.put(n+1,0);

        for (int i = 1; i <= n; i++) {
            if (studentMap.get(i)==0){
                if(studentMap.get(i-1)==2){
                    //앞에 애한테 빌려올수있으면
                    studentMap.put(i,1);
                    studentMap.put(i-1,1);
                }else if(studentMap.get(i+1)==2){
                    //뒤에 애한테 빌려올수있으면
                    studentMap.put(i,1);
                    studentMap.put(i+1,1);
                }
            }
        }

        int cnt =0;
        for(Map.Entry<Integer,Integer> entry : studentMap.entrySet()){
            if(entry.getValue()==1 || entry.getValue()==2){
                cnt++;
            }
        }

        return cnt;
    }
}
