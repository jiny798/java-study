package Algorithm;
public class Main {
    public static int cnt = 3;
    public static void main(String[] args) {
        boolean[] visited = new boolean[5];
        for (int i = 0; i < 5; i++) {
            visited[i] = true;
            BT(i,1, visited);
            visited[i] = false;
        }
    }
    public static void BT(int index,int cnt, boolean[] visited) {
        if (cnt  == 2) {
            for (int k = 0; k < 5; k++) {
                System.out.print(visited[k] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index + 1; i < 5; i++) {
            visited[i] = true;
            BT(i, cnt+1, visited);
            visited[i] = false;
        }
    }
}
