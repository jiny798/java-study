package PRG.구현;

public class 공원산책 {
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {1, -1, 0, 0};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        int x = 0;
        int y = 0;
        String[][] arr = new String[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            String[] tokens = park[i].split("");
            for (int j = 0; j < tokens.length; j++) {
                arr[i][j] = tokens[j];
                if (arr[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
            }
        }

        // routes  ["E 2","S 2","W 1"]
        for (int i = 0; i < routes.length; i++) {
            if (checkRange(x, y, routes[i], arr) && checkObstacle(x, y, routes[i], arr)) {
                int[] point = move(x, y, routes[i], arr);
                x = point[0];
                y = point[1];
            }
        }
        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr[0].length; b++) {
                if (arr[a][b].equals("S")) {
                    return new int[]{a, b};
                }
            }
        }
        return answer;
    }

    public boolean checkRange(int x, int y, String str, String[][] arr) {
        String s = str.substring(0, 1);
        int direction = getDirection(s);
        int distance = Integer.parseInt(str.substring(2, 3));
        if (dx[direction] != 0) {
            x = x + dx[direction] * distance;
        }
        if (dy[direction] != 0) {
            y = y + dy[direction] * distance;
        }
        if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length) {
            return true;
        }
        return false;
    }

    public boolean checkObstacle(int x, int y, String str, String[][] arr) {
        String s = str.substring(0, 1);
        int direction = getDirection(s);
        int distance = Integer.parseInt(str.substring(2, 3));
        for (int i = 1; i <= distance; i++) {
            x = x + dx[direction];
            y = y + dy[direction];
            if (arr[x][y].equals("X")) {
                return false;
            }
        }
        return true;
    }
    public int getDirection(String s) {
        if (s.equals("E")) {
            return 0;
        }
        if (s.equals("W")) {
            return 1;
        }
        if (s.equals("S")) {
            return 2;
        }
        if (s.equals("N")) {
            return 3;
        }
        return 0;
    }

    public int[] move(int x, int y, String str, String[][] arr) {
        String s = str.substring(0, 1);
        int direction = getDirection(s);
        int distance = Integer.parseInt(str.substring(2, 3));
        arr[x][y] = "O";
        if (dx[direction] != 0) {
            x = x + dx[direction] * distance;
        }
        if (dy[direction] != 0) {
            y = y + dy[direction] * distance;
        }
        arr[x][y] = "S";
        return new int[]{x, y};
    }
}
