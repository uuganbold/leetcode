class Solution1395 {

    /*
        T: O(N^2)
        S: O(N)
    */
    public int numTeams(int[] rating) {
        
        int[] greater=new int[rating.length];
        int[] smaller=new int[rating.length];
        
        for(int i=0;i<rating.length;i++){
            int great=0;
            int small=0;
            for(int j=i+1;j<rating.length;j++){
                if(rating[j]>rating[i]){
                    great++;
                }
                if(rating[j]<rating[i]){
                    small++;
                }
            }
            greater[i]=great;
            smaller[i]=small;
        }
        
        int ans=0;
        for(int first=0;first<rating.length;first++){
            for(int second=first+1;second<rating.length;second++){
                
                if(rating[first]<rating[second]){
                    ans+=greater[second];
                }else{
                    ans+=smaller[second];
                }
            }
        }
        
        return ans;
    }
}