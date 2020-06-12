import java.util.*;
class Solution970 {

    /*
        T: O(LogB)
        S: O(LogB)
    */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < bound; i = x * i) {
            for (int j = 1; i + j <= bound; j = j * y) {
                result.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(result);
    }
}