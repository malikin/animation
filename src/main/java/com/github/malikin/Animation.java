package com.github.malikin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animation {

    private final static char RIGHT = 'R';
    private final static char LEFT = 'L';
    private final static char BOTH = 'B';

    public static void main(String[] args) {

        var resultA = animate("..R....", 2);
        System.out.println(Arrays.toString(resultA.toArray()));

        var resultB = animate("RR..LRL", 3);
        System.out.println(Arrays.toString(resultB.toArray()));

        var resultC = animate("LRLR.LRLR", 2);
        System.out.println(Arrays.toString(resultC.toArray()));

        var resultD = animate("RLRLRLRLRL", 10);
        System.out.println(Arrays.toString(resultD.toArray()));

        var resultE = animate("...", 1);
        System.out.println(Arrays.toString(resultE.toArray()));

        var resultF = animate("LRRL.LR.LRR.R.LRRL.", 1);
        System.out.println(Arrays.toString(resultF.toArray()));
    }

    public static List<String> animate(String init, int speed) {
        var acc = new ArrayList<String>();
        animate(init, speed, acc);
        return acc;
    }

    private static void animate(String input, int speed, List<String> acc) {
        if (!input.contains("R") && !input.contains("L")) {
            acc.add(input);
            return;
        }
        var result = input.replaceAll("(R|L|B)", "X");
        acc.add(result);

        var rPositions = new ArrayList<Integer>();
        var lPositions = new ArrayList<Integer>();

        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            int newPositionR = i + speed;
            int newPositionL = i - speed;

            if (ch == RIGHT) {
                if (newPositionR < charArray.length) {
                    rPositions.add(newPositionR);
                }
                continue;
            }
            if (ch == LEFT) {
                if (newPositionL >= 0) {
                    lPositions.add(newPositionL);
                }
                continue;
            }
            if (ch == BOTH) {
                if (newPositionL >= 0) {
                    lPositions.add(newPositionL);
                }
                if (newPositionR < charArray.length) {
                    rPositions.add(newPositionR);
                }
            }
        }

        var newInput = ".".repeat(input.length());

        if (lPositions.isEmpty() && rPositions.isEmpty()) {
            animate(newInput, speed, acc);
            return;
        }

        var newInputArr = newInput.toCharArray();

        for (int i = 0; i < newInputArr.length; i++) {
            if (lPositions.contains(i) && rPositions.contains(i)) {
                newInputArr[i] = BOTH;
                continue;
            }
            if (rPositions.contains(i)) {
                newInputArr[i] = RIGHT;
                continue;
            }
            if (lPositions.contains(i)) {
                newInputArr[i] = LEFT;
            }
        }

        animate(String.valueOf(newInputArr), speed, acc);
    }
}
