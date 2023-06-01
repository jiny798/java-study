package Algorithm;

public class Main {
    public static int cnt = 3;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, 2, 3, 4, 5};
        boolean[] visited = new boolean[5];
        for (int i = 0; i < 5; i++) {
            visited[i] = true;
            BT(i, 0, arr, visited);
            visited[i] = false;
        }
    }

    public static void BT(int index, int c, int[] arr, boolean[] visited) {
        if (cnt - 1 == c) {
            for (int k = 0; k < 5; k++) {
                System.out.print(visited[k] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = index + 1; i < 5; i++) {
            visited[i] = true;
            BT(i, c + 1, arr, visited);
            visited[i] = false;
        }

    }
}
