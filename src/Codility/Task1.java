package Codility;

public class Task1 {
    public int solution(int N) {
        String binary = Integer.toBinaryString(N);
        int minValue = 0;

        String[] str = binary.substring(binary.indexOf("1") + 1, binary.lastIndexOf("1") + 1)
                .split("1");

        for (String s : str) {
            if (s.length() > minValue) {
                minValue = s.length();
            }
        }
        return minValue;
    }

}
