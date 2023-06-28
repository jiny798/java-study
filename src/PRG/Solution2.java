package PRG;

public class Solution2 {
    public static String[] CHECK_STR_ARR = {"B", "A", "N", "A", "N", "A"};
    public int solution(String S) {
        int count = 0;
        while (true) {
            if (isIncludedBANANA(S)) {
                count++;
                S = removeStr(S);
                System.out.println(S);
                continue;
            }else {
                break;
            }
        }
        return count;
    }

    public boolean isIncludedBANANA(String string) {
        String tempStr = string;
        for (String s : CHECK_STR_ARR) {
            if (tempStr.indexOf(s) < 0) {
                return false;
            } else {
                tempStr = tempStr.replaceFirst(s, "");
            }
        }
        return true;
    }

    public String removeStr(String string) {
        String tempStr = string;
        for (String s : CHECK_STR_ARR) {
            tempStr = tempStr.replaceFirst(s, "");
        }
        return tempStr;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        System.out.println(solution2.solution("NAANAAXNABABYNNBZ"));
    }

}
