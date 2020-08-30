import java.util.*;

class Solution1557 {

    /*
     * T: O(E) S: O(N)
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        boolean[] incoming = new boolean[n];
        for (int i = 0; i < edges.size(); i++) {
            incoming[edges.get(i).get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!incoming[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}