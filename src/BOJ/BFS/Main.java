package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보 k
        int X = Integer.parseInt(st.nextToken()); // 출발도시의 번호

        ArrayList<Integer>[] arr = new ArrayList[N + 1];

        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (arr[x] == null) {
                arr[x] = new ArrayList<>();
            }
            arr[x].add(y);
        }

        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> sizeQue = new LinkedList<>();

        que.add(X); // 1번 출발
        sizeQue.add(0);
        int distance = 0;
        int[] visited = new int[N + 1];
        visited[X] = 1;
        ArrayList<Integer> answer = new ArrayList<>();

        Loop:
        while (!que.isEmpty()) {
            int x = que.poll();
            int size = sizeQue.poll();
            if (size == K) {
                answer.add(x);
            }

            if (arr[x] != null) {
                ArrayList<Integer> list = arr[x];

                for (int i = 0; i < list.size(); i++) {
                    if (visited[list.get(i)] == 0) {
                        visited[list.get(i)] = 1;
                        que.add(list.get(i));
                        sizeQue.add(size + 1);
                    }
                }
            }
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            answer.stream().forEach(o -> {
                System.out.println(o);
            });
        }

    }
}
