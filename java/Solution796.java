class Solution796 {

    /*
        T: O(N^2)
        S: O(N)

        TODO: Should exercise on Knuth-Morris-Pratt Pattern Searching algorithm. This will solve the problem in linear time.
    */
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()) return false;
        return (A+A).indexOf(B)>=0;
    }

    public int KMPAlgorithm(String A, String B){
        int[] shift=KMPPatternShift(B);
       
       int a=0;
       int b=0;
       while(a<A.length()&&b<B.length()){
           if(A.charAt(a)==B.charAt(b)){
               a++;
               b++;
           }else{
               if(b!=0){
                   b=shift[b-1];
               }else{
                   a++;
               }
           }
       }
       
       if(b==B.length()){
           return a-b;
       }
       
       return -1;
   }
   
   private int[] KMPPatternShift(String str){
       int[] ans=new int[str.length()];
       
       int left=0;
       for(int right=1;right<str.length();right++){
           while(left>0&&str.charAt(left)!=str.charAt(right)){
               left=ans[left-1];
           }
           if(str.charAt(left)!=str.charAt(right)){
                ans[right]=0;
           }else{
               ans[right]=++left;
           }
       }
       
       return ans;
   }
}