class Solution1925 {
    /*
        T: O(1)
        S: O(1)

        if N is even, choose 1 to make it odd. Then the opponent has only option to make it even.
    */
    public boolean divisorGame(int N) {
        return N%2==0;
    }
}