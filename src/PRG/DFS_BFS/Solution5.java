package PRG.DFS_BFS;

import java.util.*;

public class Solution5 {
    public static int cnt=0;
    public static Map<String,Integer> map = new HashMap<>();
    public static boolean tag = false;
    public String[] solution(String[][] tickets) {

        String[] airPort = new String[tickets.length+1];
        Arrays.sort(tickets,((o1, o2) ->{
            return o1[1].compareTo(o2[1]);
        } ));
        boolean[] checked = new boolean[airPort.length];
        List<String> list = new ArrayList<>();
        Stack<String> st = new Stack<>();

        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")){
                checked[i]=true;
                st.add("ICN");
                dfs(tickets[i][1],tickets,checked,1,st);
                if(tag){
                    break;
                }
                st.pop();
                checked[i]=false;
            }
        }

        Iterator it = st.iterator();
        int i=0;
        while (it.hasNext()){
            airPort[i++] = (String) it.next();
        }
        return airPort;
    }
    public void dfs(String port,String[][] tickets,boolean[] checked,int count,Stack<String> st){
        if(count == tickets.length){
            st.add(port); //마지막 공항
            tag=true;
            return;
        }
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(port) && checked[i]==false ){
                checked[i]=true;
                st.add(port);
                dfs(tickets[i][1],tickets,checked,count+1,st);
                if(tag){
                    break;
                }
                st.pop();
                checked[i]=false;
            }
        }
    }
}
