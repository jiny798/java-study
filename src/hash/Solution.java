package hash;

import java.util.HashMap;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pickSize = nums.length / 2;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i : nums){
            if(map.get(i)==null){
                map.put(i,1);
            }else{
                continue;
            }
        }

        int typeCount = map.size();
        if(typeCount <= pickSize){ //포켓몬 종류가 고를수 있는 개수 이하라면
            return typeCount;
        }else{
            return pickSize; //포켓몬 종류는 많은데, 고를수 있는 개수는 정해져있다면
        }
    }


}
