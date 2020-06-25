class Solution414 {

    /*
        T: O(N)
        S: O(1)
    */
    public int thirdMax(int[] nums) {
        Integer first=null;
        Integer second=null;
        Integer third=null;
        
        for(int n:nums){
            if(first==null||n>first){
                third=second;
                second=first;
                first=n;
            }else if(first!=n&&(second==null||n>second)){
                third=second;
                second=n;
            }else if(first!=n&&second!=n&&(third==null||n>third)){
                third=n;
            }
        } 
        
        if(third!=null){
            return third;
        }else{
            return first;
        }
    }
}