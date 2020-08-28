import java.util.*;

class Solution1561 {

    /*
     * T: O(nlogN) S: O(1)
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = piles.length - 2;
        int ans = 0;
        int number = 0;
        while (number < piles.length / 3) {
            ans += piles[i];
            i -= 2;
            number++;
        }

        return ans;
    }
}