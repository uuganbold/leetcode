class Solution504 {

    /*
        T: O(logN)
        S: O(logN)
    */
    public String convertToBase7(int num) {
        StringBuilder ans=new StringBuilder();
        
        if(num<0){
            ans.append("-");
            num=Math.abs(num);
        }
        
        int sevenProducts=1;
        while(sevenProducts*7<=num){
            sevenProducts*=7;
        }
        
        while(sevenProducts>0){
            int digit=num/sevenProducts;
            ans.append(digit);
            num=num-digit*sevenProducts;
            sevenProducts/=7;
        }
        
        return ans.toString();
    }
}