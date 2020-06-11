class Solution1033 {

    /*
        T: O(1)
        S: O(1)
    */
    public int[] numMovesStones(int a, int b, int c) {
        if(a>b){
            int t=a;
            a=b;
            b=t;
        }
        if(a>c){
            int t=a;
            a=c;
            c=t;
        }
        if(b>c){
            int t=b;
            b=c;
            c=t;
        }
        int min=0;
        int max=0;
        if(a+1==b&&b+1==c){
            min=0;
        }else if(a+1==b||b+1==c||a+2==b||b+2==c){
            min=1;
        }else{
            min=2;
        }
        
        max=(b-a-1)+(c-b-1);
        
        return new int[]{min,max};
    }
}