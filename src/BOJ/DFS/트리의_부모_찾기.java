package BOJ.DFS;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 트리의_부모_찾기 {
    public static int[] answer;
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;
    public static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int N = Integer.parseInt(line1);
        size =  N ;

        answer = new int[N + 1];
        visited = new boolean[N+1];
        arr = new ArrayList[N+1];
        for (int i = 1 ; i<=N ; i++){ // N = 7
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < N; i++) {
            String repeatLine = br.readLine();
            String[] tokens = repeatLine.split(" ");
            int front = Integer.parseInt(tokens[0]);
            int back = Integer.parseInt(tokens[1]);

            arr[front].add(back);
            arr[back].add(front);
        }
        visited[1] = true;
        for (int i = 1; i < N + 1; i++) {
            if(visited[i] == false && arr[1].contains(i)) {
                answer[i] = 1;
                dfs(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            stringBuilder.append(answer[i] + "\n");
        }
        System.out.println(stringBuilder);
    }

    public static void dfs( int y) {
        visited[y] = true;
        for (int i : arr[y]){
            if(visited[i] == false) {
                answer[i] = y;
                dfs( i);
            }
        }



    }
}
