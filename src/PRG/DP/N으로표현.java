package PRG.DP;

import java.util.*;

public class N으로표현 {
    public int solution(int N, int number) { // 5로 12 만들기
        //DP[1] -> 1개로 만들수 있는 수
        //DP[2] -> DP[1] + DP[1] , DP[1] - DP[1], DP[1] * DP[1] ...
        //DP[3] -> DP[1] +-*/ DP[2], DP[2] +-*/ DP[1]

        Set<Integer> tempSet = new HashSet<>();
        Map<Integer, Set> map = new HashMap<>();
        tempSet.add(N);
        map.put(1, tempSet);

        for (int i = 2; i <= 8; i++) {  // i == 3
            Set<Integer> resultSet = new HashSet<>();
            String str = "";
            for (int strIndex = 0; strIndex < i; strIndex++) {
                str += N;
            }
            resultSet.add(Integer.parseInt(str));
            for (int a = 1; a < i; a++) { // a = 1 , 2
                int b = i - a;     //  b = 2 , 1
                Set<Integer> set1 = map.get(a);
                Set<Integer> set2 = map.get(b);
                Iterator<Integer> it1 = set1.iterator();


                while (it1.hasNext()) {
                    int x = it1.next();
                    Iterator<Integer> it2 = set2.iterator();
                    while (it2.hasNext()) {
                        int y = it2.next();
                        resultSet.add(x + y);
                        resultSet.add(x - y);
                        resultSet.add(x * y);
                        if (y != 0) {
                            resultSet.add(x / y);
                        }

                    }
                }
                map.put(i, resultSet);
            }
        } // for end
        int answer = -1;
        for (int i = 1; i <= 8; i++) {
            Set<Integer> findSet = map.get(i);
            if (findSet.contains(number)) {
                answer = i;
                break;
            }
        }

        return answer;//N 으로 number를 만들수있는 최소 DP[] 를 구한다
    }

}
