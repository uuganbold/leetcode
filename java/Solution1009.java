class Solution1009 {

    /*
        T: O(1)
        S: O(1)
    */
    public int bitwiseComplement(int N) {
        int comp = 1;
        while (comp < N) 
            comp = (comp << 1) | 1;
        return N ^ comp;
    }
}