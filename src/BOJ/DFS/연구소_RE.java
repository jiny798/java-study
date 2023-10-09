package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연구소_RE { // 0은 빈칸 , 1은 벽 , 2는 바이러스
	public static int N = 0;
	public static int M = 0;

	public static int MAX_SAFE_AREA = 0;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstStr = br.readLine().split(" ");
		N = Integer.parseInt(firstStr[0]);
		M = Integer.parseInt(firstStr[1]);

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		BT(map, 0);
		System.out.println(MAX_SAFE_AREA);
	}

	public static void BT(int[][] map, int cnt) {
		if (cnt == 3) {
			int safe = getSafeCount(map);
			if(MAX_SAFE_AREA < safe){
				MAX_SAFE_AREA = safe;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					BT(map, cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static int getSafeCount(int[][] map) {
		int[][] arr = new int[N][M];
		initArr(arr, map);
		spreadVirus(arr);
		return getCount(arr);
	}

	public static int getCount(int[][] arr){
		int cnt = 0 ;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0){
					cnt++;
				}
			}
		}
		// print(arr);
		return cnt;
	}

	public static void spreadVirus(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 2) {
					dfs(i, j, arr);
				}
			}
		}
	}

	public static void dfs(int x, int y, int[][] arr) {
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (arr[nx][ny] == 0) {
					arr[nx][ny] = 2;
					dfs(nx, ny, arr);
				}
			}
		}
	}

	public static void initArr(int[][] newArr, int[][] copyArr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newArr[i][j] = copyArr[i][j];
			}
		}
	}

	public static void print(int[][] arr){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

	}
}
