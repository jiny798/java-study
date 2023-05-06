package PRG.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public String solution(String[] participant, String[] completion) {
        final String[] answer = new String[1];
        Map<String,Integer> map = new HashMap<>();
        Arrays.stream(participant).forEach((user)->{
            if(map.get(user)==null){
                map.put(user,1);
            }else{
                map.put(user,map.get(user)+1);
            }
        });

        Arrays.stream(completion).forEach((user)->{
            map.put(user,map.get(user)-1);
        });

        map.forEach((user,i)->{
            if(i>0){
                answer[0] = user;
            }
        });


        return answer[0];
    }
}
