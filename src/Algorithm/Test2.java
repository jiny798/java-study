package Algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test2 {
    public int solution(int[][] relationships, int target, int limit) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i < relationships.length; i++) {
            if (relationships[i][0] == target) {
                count++;
                set.add(relationships[i][1]);
            } else if (relationships[i][1] == target){
                count++;
                set.add(relationships[i][1]);
            }
        }

        Iterator<Integer> it = set.iterator(); // 1,3,6
        Set<Integer> set2 = new HashSet<>();
        while (it.hasNext()){
            int m = it.next();
            dfs(set,set2,relationships,m,1,limit);
        }
        int result = (set.size()*5 ) + (set2.size() * 10);

        answer = result + set2.size();

        return answer;
    }

    public void dfs(Set<Integer> set1,Set<Integer> set2,int[][] relationships, int n,int cnt,int limit){
        if (cnt == limit){
            return;
        }
        for (int i = 0; i < relationships.length; i++) {
            if (relationships[i][0] == n) {
                set2.add(relationships[i][1]);
            } else if (relationships[i][1] == n){
                set2.add(relationships[i][1]);
            }
        }
    }
}
