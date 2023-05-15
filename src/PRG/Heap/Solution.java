package PRG.Heap;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        // 1,2,3,9,10,12  K = 7 , return 2
        PriorityQueue<Integer> priQue = new PriorityQueue<>();
        for(int i : scoville){
            priQue.add(i);
        }

        int changeCount =0;
        while (true){
            int MinNum = priQue.poll();
            if(MinNum >= K){ // K 이상 만들수 있는 경우
                break;
            }
            if(priQue.size() ==0){ // K 이상 만들수 없는 경우
                changeCount = -1;
                break;
            }
            int MinNum2 = priQue.poll();
            int result = MinNum + (MinNum2*2);
            changeCount++;
            priQue.add(result);
        }

        return changeCount;
    }
}
