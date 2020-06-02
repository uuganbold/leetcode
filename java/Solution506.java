import java.util.*;
class Solution506 {
    
    /*
        T: O(NlogN)
        S: O(N)
    */
    public String[] findRelativeRanks(int[] nums){
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        
        Map<Integer,Integer> mapToRank=new HashMap<>();
        for(int i=0;i<sorted.length;i++){
            mapToRank.put(sorted[i],sorted.length-i);
        }
        
        String[] ans=new String[nums.length];
        for(int i=0;i<nums.length;i++){
             int rank=mapToRank.get(nums[i]);
             
             switch(rank){
                 case 1:{
                     ans[i]="Gold Medal";
                     break;
                 }
                 case 2:{
                     ans[i]="Silver Medal";
                     break;
                 }
                 case 3:{
                     ans[i]="Bronze Medal";
                     break;
                 }
                 default:{
                     ans[i]=String.valueOf(rank);
                 }
             }
        }
        
        return ans;
        
    }
    
    class Person{
        int index;
        int score;
        
        public Person(int index,int score){
            this.index=index;
            this.score=score;
        }
    }
    
    /*
        T: O(NlogN)
        S: O(N)
    */
    public String[] findRelativeRanksPriorityQueue(int[] nums) {
        Queue<Integer> ranks = new PriorityQueue<>((i1, i2) -> nums[i2] - nums[i1]);
        
        String[] res = new String[nums.length];
        
        for(int i = 0;i<nums.length;i++){
            ranks.offer(i);
        }        
        
        int i = 1;
        while(!ranks.isEmpty()){
            int index = ranks.poll();
            if(i == 1){
                res[index] = "Gold Medal";
            }else if(i == 2){
                res[index] = "Silver Medal";
            }else if(i == 3){
                res[index] = "Bronze Medal";
            }else{
                res[index] = String.valueOf(i);
            }
            i++;
        }
        return res;
    }
    
    /*
        T: O(NlogN)
        S: O(N)
    */
    public String[] findRelativeRanksSort(int[] nums) {
        String[] ans=new String[nums.length];
        
        Person[] people=new Person[nums.length];
        for(int i=0;i<nums.length;i++){
            people[i]=new Person(i,nums[i]);
        }
        
        Arrays.sort(people,(p1,p2)->{
            return p2.score-p1.score;
        });
        
        for(int i=0;i<people.length;i++){
             switch(i){
                 case 0:{
                     ans[people[i].index]="Gold Medal";
                     break;
                 }
                 case 1:{
                     ans[people[i].index]="Silver Medal";
                     break;
                 }
                 case 2:{
                     ans[people[i].index]="Bronze Medal";
                     break;
                 }
                 default:{
                     ans[people[i].index]=String.valueOf(i+1);
                 }
             }
        }
        
        return ans;
        
    }
}