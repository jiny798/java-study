package PRG.kakao.blind;

public class 프렌즈4블록 {
	public static boolean tag = true;

	public int solution(int m, int n, String[] board) {
		int answer = 0;

		String[][] map = new String[board.length][board[0].length()];
		boolean[][] visit = new boolean[map.length][map[0].length];
		tag = true;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = board[i].substring(j, j + 1);
			}
		}

		while (tag) {
			tag = false;
			visit = new boolean[map.length][map[0].length];
			for (int i = 0; i < map.length - 1; i++) {
				for (int j = 0; j < map[0].length - 1; j++) {
					checkBoard(i, j, map, visit);
				}
			}
			answer += breakBoard(map, visit);
			moveBoard(map);
		}

		return answer;
	}

	public void checkBoard(int i, int j, String[][] board, boolean[][] visit) {
		String word = board[i][j];
		if (!word.equals("") &&
			word.equals(board[i][j + 1]) &&
			word.equals(board[i + 1][j]) &&
			word.equals(board[i + 1][j + 1])) {
			visit[i][j] = true;
			visit[i][j + 1] = true;
			visit[i + 1][j] = true;
			visit[i + 1][j + 1] = true;
			tag = true;
		}

	}

	public int breakBoard(String[][] board, boolean[][] visit) {
		int breakBlock = 0;
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[0].length; j++) {
				if (visit[i][j] == true) {
					breakBlock++;
					board[i][j] = "";
				}
			}
		}
		return breakBlock;
	}

	public void moveBoard(String[][] board) {
		for (int j = 0; j < board[0].length; j++) {
			for (int i = board.length - 1; i > 0; i--) {
				if (board[i][j].equals("")) {
					pull(i, j, board);
				}
			}
		}
	}

	public void pull(int i, int j, String[][] board) {
		for (int index = i; index >= 0; index--) {
			if (!board[index][j].equals("")) {
				board[i][j] = board[index][j];
				board[index][j] = "";
				break;
			}
		}
	}

	public void printArr(String[][] board) {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].equals("")) {
					System.out.print(" ");
				}
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
