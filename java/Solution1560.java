import java.util.*;

class Solution1560 {

    /*
     * T: O(n) S: O(1)
     */
    public List<Integer> mostVisited(int n, int[] rounds) {
        int start = rounds[0];
        int total = 0;
        for (int i = 1; i < rounds.length; i++) {
            int end = rounds[i];
            if (end >= start) {
                total += end - start;
            } else {
                total += end + n - start;
            }
            start = end;
        }

        int diff = (total + 1) % n;
        if (diff == 0) {
            diff = n;
        }

        List<Integer> ans = new ArrayList<>();

        if (rounds[0] + diff - 1 > n) {
            for (int i = 1; i < rounds[0] + diff - n; i++) {
                ans.add(i);
            }
            for (int i = rounds[0]; i <= n; i++) {
                ans.add(i);
            }
        } else {
            for (int i = 0; i < diff; i++) {
                ans.add(rounds[0] + i);
            }
        }
        return ans;

    }
}