import java.util.*;
class Solution475 {
    
    /*
        T: O(MlogM+HlogN+M*LogMAX)
        S: O(1)
    */
    public int findRadius(int[] houses, int[] heaters){
        if(houses.length==0||heaters.length==0){
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int low=0;
        int high=Math.abs(Math.max(houses[houses.length-1], heaters[heaters.length-1])-houses[0]);
        
        while(low<high){
            int mid=low+(high-low)/2;
            
            if(covers(houses,heaters,mid)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        
        return low;
    }
    
    /*
        O(M)
    */
    private boolean covers(int[] houses, int[] heaters, int radius){
        int heater=0;
        int left=heaters[heater]-radius;
        int right=heaters[heater]+radius;
        
        for(int h=0;h<houses.length;h++){
            if(houses[h]<left){
                return false;
            }else if(houses[h]>right){
                heater++;
                if(heater>=heaters.length){
                    return false;
                }
                left=heaters[heater]-radius;
                right=heaters[heater]+radius;
                h--;
            }
        }
        
        return true;
    }
    
    /**
     * House-M
     * Heater-N
     * T: O((M+N)*LogN)
     * S: O(N)
     */
    public int findRadiusTreeSet(int[] houses, int[] heaters) {
        TreeSet<Integer> heaterSet=new TreeSet<>();
        for(int h:heaters){
            heaterSet.add(h);
        }
        
        int max=0;
        for(int h:houses){
            
            Integer left=heaterSet.floor(h);
            Integer right=heaterSet.ceiling(h);
            
            if(left==null){
                left=Integer.MAX_VALUE;
            }else{
                left=h-left;
            }
            
            if(right==null){
                right=Integer.MAX_VALUE;
            }else{
                right=right-h;
            }
            
            max=Math.max(max,Math.min(left,right));
            
        }
         
        return max;
         
    }
}