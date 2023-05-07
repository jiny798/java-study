package PRG.hash;

import java.util.HashMap;

public class Solution4 {
    public int solution(String[][] clothes) {
        //경우의 수 = (종류의 수+1) + (종류의 수+1)
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length ; i++){
            if(map.get(clothes[i][1])==null){
                map.put(clothes[i][1],2);
            }else{
                map.put(clothes[i][1], map.get(clothes[i][1])+1 );
            }
        }

        int sum=1;
        for(String str : map.keySet() ){
            sum *= map.get(str);
        }
        return sum-1;

    }
}
