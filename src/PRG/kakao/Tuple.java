package PRG.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tuple {
    public int[] solution(String s) {
        String str = s.substring(1, s.length() - 1);
        ArrayList<String> list = new ArrayList<>();

        String numStr = "";
        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                start = i;
            } else if (str.charAt(i) == '}') {
                end = i;
                numStr = str.substring(start + 1, end);

                list.add(numStr);
                numStr = "";
            }
        }

        Collections.sort(list, ((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return 0;
        }));

        Set<String> set = new HashSet<>();
        ArrayList<Integer> nlist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String nStr = list.get(i);

            String[] strArr = nStr.split(",");

            for (int j = 0; j < strArr.length; j++) {
                if (!set.contains(strArr[j])) {
                    set.add(strArr[j]);
                    nlist.add(Integer.parseInt(strArr[j]));
                }
            }
        }

        int[] answer = new int[nlist.size()];
        for (int i = 0; i < nlist.size(); i++) {
            answer[i] = nlist.get(i);
        }

        return answer;
    }

}
