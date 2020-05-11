import java.util.*;

class Solution1237 {
    public static abstract class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public abstract int f(int x, int y);
    };

    /*
        T: O(NlogM)
        S: O(1)
    */
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> results = new ArrayList<>();

        int yLo = 1, yHi = 1000;

        for (int x = 1; x <= 1000; x++) {
            yLo = 1;
            while (yLo <= yHi) {
                int y = (yLo + yHi) / 2;
                int myZ = customfunction.f(x, y);
                if (myZ == z)
                    results.add(List.of(x, y));
                if (myZ > z)
                    yHi = y - 1;
                else
                    yLo = y + 1;
            }
        }

        return results;
    }
}