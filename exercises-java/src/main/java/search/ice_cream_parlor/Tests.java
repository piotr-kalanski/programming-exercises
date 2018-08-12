package search.ice_cream_parlor;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        runTest(new int [] {1,4,5,3,2}, 4);
        runTest(new int [] {2,2,4,3}, 4);
    }

    public static void runTest(int[] cost, int money) {
        System.out.println("\n\nINPUT:");
        System.out.println(Arrays.toString(cost));
        System.out.println(money);

        Solution.whatFlavors(cost, money);
    }
}

