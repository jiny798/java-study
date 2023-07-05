package PRG.kakao;

import Algorithm.MyLinkedList.List;

import java.util.Arrays;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        int[] leftHand = {3, 0};
        int[] rightHand = {3, 2};
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) numbers[i] = 11;
            int x = (int) (Math.ceil(numbers[i] / 3d)) - 1;
            int y = (numbers[i] % 3 == 0) ? 2 : (numbers[i] % 3) - 1;


            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                leftHand[0] = x;
                leftHand[1] = y;
                builder.append("L");
                continue;
            }
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                rightHand[0] = x;
                rightHand[1] = y;
                builder.append("R");
                continue;
            }
            // 0,2   1, 0     1,1
            int distanceFromRightHand = calculateDistance(rightHand, x, y);
            int distanceFromLeftHand = calculateDistance(leftHand, x, y);
            if (distanceFromRightHand == distanceFromLeftHand) {
                if (hand.equals("left")) { // 왼손잡이
                    leftHand[0] = x;
                    leftHand[1] = y;
                    builder.append("L");
                } else { //오른손잡이
                    rightHand[0] = x;
                    rightHand[1] = y;
                    builder.append("R");
                }
            } else if (distanceFromLeftHand < distanceFromRightHand) { //왼쪽손이 더 가까우면
                leftHand[0] = x;
                leftHand[1] = y;
                builder.append("L");
            } else { //오른쪽손이 더 가깝
                rightHand[0] = x;
                rightHand[1] = y;
                builder.append("R");
            }
        }
        return builder.toString();
    }

    public int calculateDistance(int[] hand, int x, int y) {
        return Math.abs(hand[0] - x) + Math.abs(hand[1] - y);
    }
}
