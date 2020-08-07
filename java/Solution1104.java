import java.util.*;

class Solution1104 {

    /*
     * T: O(logN) S: O(1)
     */
    public List<Integer> pathInZigZagTree(int label) {
        int level = (int) (Math.log(label) / Math.log(2));

        LinkedList<Integer> ans = new LinkedList<Integer>();
        while (level >= 0) {
            ans.addFirst(label);
            label /= 2;
            level--;
            label = mirrorInLevel(level, label);
        }

        return ans;
    }

    private int mirrorInLevel(int level, int target) {
        int power2 = 1 << level;
        return 3 * power2 - target - 1;
    }
}