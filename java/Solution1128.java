class Solution1128 {

    /*
        T: O(N)
        S: O(1)
    */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] instances=new int[10][10];
        
        int count=0;
        for(int[] aDomino: dominoes){
            count+=instances[aDomino[0]][aDomino[1]];
            if(aDomino[0]!=aDomino[1]) count+=instances[aDomino[1]][aDomino[0]];
            instances[aDomino[0]][aDomino[1]]++;
        }
        
        return count;
    }
}