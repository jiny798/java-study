package BOJ.유니온파인드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 집합의표현 {
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< M ; i++){
			String[] arr = br.readLine().split(" ");
			if( arr[0].equals("0") ){
				union(Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
			}else if( arr[0].equals("1") ){
				sb.append(isSame( Integer.parseInt(arr[1]),Integer.parseInt(arr[2]) ) );
			}
		}
		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	public static int find(int x){
		if(parent[x] == x){
			return x;
		}else{
			return parent[x] = find(parent[x]);
		}
	}

	public static void union(int a, int b){
		int xParent = find(a);
		int yParent = find(b);
		if(xParent < yParent){
			parent[yParent] = xParent;
		}else{
			parent[xParent] = yParent;
		}
	}

	public static String isSame(int a, int b){
		int xParent = find(a);
		int yParent = find(b);

		if(xParent == yParent){
			return "YES\n";
		}else{
			return "NO\n";
		}
	}
}
