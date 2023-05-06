import PRG.hash.Solution;
import PRG.hash.Solution5;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500	};

        Solution5 solution5 = new Solution5();
        int[] arr = solution5.solution(genres,plays);

        for(int i : arr){
            System.out.println(i);
        }
    }
}