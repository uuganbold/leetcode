class Solution1103 {

    /*
        T: O(num_people)
        S: O(1)
    */
    public int[] distributeCandies(int candies, int num_people) {
        int oneRound=(num_people)*(num_people+1)/2;
        int r=0;
        int sum=0;
        
        int thisRound=oneRound;
        while(sum+thisRound<=candies){
            sum+=thisRound;
            r++;
            thisRound=thisRound+num_people*num_people;
        }
        
        int remaining=candies-sum;
        
        int[] ans=new int[num_people];
        
        int base=(r-1)*r*num_people/2;
        thisRound=r*num_people+1;
        
        for(int i=0;i<num_people;i++){
            ans[i]=base+(i+1)*r;
            
            if(remaining>=thisRound){
                ans[i]+=thisRound;
                remaining-=thisRound;
                thisRound++;
            }else if(remaining>0){
                ans[i]+=remaining;
                remaining=0;
            }
        }
        
        return ans;
        
    }
}