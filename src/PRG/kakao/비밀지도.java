package PRG.kakao;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] resultArr = new int[n];

        for (int i = 0; i < n; i++) {
            resultArr[i] = arr1[i] | arr2[i];
        }

        for (int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(resultArr[i]); // 001100
            str = addZero(str, n);
            str = str.replaceAll("1", "#");
            str = str.replaceAll("0", " ");
            answer[i] = str;
        }

        return answer;
    }

    public String addZero(String str, int n) {
        while (str.length() != n) {
            str = "0" + str;
        }
        return str;
    }
}
