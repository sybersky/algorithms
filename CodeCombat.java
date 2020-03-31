package algorithms;

import java.util.ArrayList;
import java.util.Random;

/** Cloudrip Mountain.subarray-retreat */
public class CodeCombat {
    public static void main(String[] args) {
        ArrayList<Integer> gems = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 19; i++)
            gems.add(r.nextInt(21) - 10);

        System.out.println(gems);
        naiveMaxSum(gems);
        dynamicMaxSum(gems);
    }

    static void dynamicMaxSum(ArrayList<Integer> gems) {
        int cycles = 0;
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int maxEndHere = 0;
        int currentStartIndex = 0;
        int maxBest = 0;
        for (int i = 0; i < gems.size(); i++) {
            cycles++;
            maxEndHere += gems.get(i);
            if (maxEndHere < 0) {
                maxEndHere = 0;
                currentStartIndex = i + 1;
            }
            if (maxEndHere > maxBest) {
                maxStartIndex = currentStartIndex;
                maxEndIndex = i;
                maxBest = maxEndHere;
            }
        }
        System.out.println("Динамичный занимает " + cycles + " циклов.");
        System.out.println(maxStartIndex + "-" + maxEndIndex + " =" + maxBest);
    }

    static void naiveMaxSum(ArrayList<Integer> gems) {
        int cycles = 0;
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int maxBest = 0;
        int sum = 0;
        for (int i = 0; i < gems.size(); i++) {
            sum = 0;
            for (int j = i; j < gems.size(); j++) {
                cycles++;
                sum += gems.get(j);
                if (sum > maxBest) {
                    maxStartIndex = i;
                    maxEndIndex = j;
                    maxBest = sum;
                }
            }
        }
        System.out.println("Брутфорс занимает " + cycles + " циклов.");
        System.out.println(maxStartIndex + "-" + maxEndIndex + " =" + maxBest);
    }
}
