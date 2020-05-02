class Solution832 {
    /*
    T : O(n)
    S : O(1)
    */
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            int length=A[i].length;
            for(int j=0;j<length/2;j++){
                int temp=A[i][j];
                A[i][j]=1^A[i][length-1-j];
                A[i][length-1-j]=1^temp;
            }
            if(length%2==1){
                A[i][length/2]^=1;
            }
        }
        return A;
    }
}