class Solution796 {

    /*
        T: O(N^2)
        S: O(N)

        Should exercise on Knuth-Morris-Pratt Pattern Searching algorithm. This will solve the problem in linear time.
    */
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()) return false;
        return (A+A).indexOf(B)>=0;
    }
}