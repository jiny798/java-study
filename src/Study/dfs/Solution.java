package Study.dfs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
	public static Set<String> set = new HashSet<>();
	public String[] solution(String str, int t){
		boolean[] visit = new boolean[str.length()];
		for(int i = 0 ; i < str.length() ; i++){
			visit[i] = true;
			dfs(i, visit, str, t);
			visit[i] = false;
		}

		Iterator it = set.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}

		return null;
	}
	public void dfs(int index, boolean[] visit, String str, int t){ //[위치,가중치]
		PriorityQueue<int[]> que = new PriorityQueue<>((arr1,arr2)->arr1[1] - arr2[1]);

		for(int v=0;v<visit.length;v++) {
			if (visit[v] == true) {
				que.add(new int[]{v, (v+1)*10 + t*10 + 5} );
			} else {
				que.add(new int[]{v, (v+1)*10 } );
			}
		}
		String res = "";
		while(!que.isEmpty()){
			int[] arr = que.poll();
			res+= str.substring(arr[0],arr[0]+1);
		}
		// System.out.println(res);
		set.add(res);

		for (int i = index+1 ; i<str.length() ; i++){
			if(visit[i] == false){
				visit[i] = true;
				dfs(i,visit,str,t);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("YOLO",2);
	}


}
