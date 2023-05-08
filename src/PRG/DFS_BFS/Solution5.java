package PRG.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution5 {
    public String[] solution(String[][] tickets) {

        String[] airPort = new String[tickets.length+1];
        Arrays.sort(tickets,((o1, o2) ->{
            return o1[0].compareTo(o2[0]);
        } ));
        for(int i=0;i<tickets.length;i++){
            airPort[i] = tickets[i][0];  // "ICN", "JFK", "HND",
        }
        boolean[] checked = new boolean[airPort.length];

        dfs();


        return null;
    }
    public void dfs(int i,String[][] tickets,boolean[] checked){

    }
}
