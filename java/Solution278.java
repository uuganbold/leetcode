/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public abstract class Solution278 {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (isBadVersion(mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo;
    }

    protected abstract boolean isBadVersion(int n);
}