import PRG.DFS_BFS.Solution2;
import PRG.DFS_BFS.Solution3;
import PRG.DFS_BFS.Solution5;

public class Main {
    public static void main(String[] args) {

        Solution5 solution5 = new Solution5();
        String[][] arr = {{"ICN","JFK"},{"HND", "IAD"},{"JFK", "HND"}};

        String[][] arr2 ={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println();
        String[] Ar= solution5.solution(arr2);

//        for(String str : Ar){
//            System.out.println(str);
//        }

    }
}