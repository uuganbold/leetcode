import java.util.*;
class Solution1460 {
    
    /*
        T: O(N)
        S: O(N)
    */
    public boolean canBeEqual(int[] target, int[] arr){
        Map<Integer,Integer> numbers=new HashMap<>();
        for(int n:target){
            numbers.put(n,numbers.getOrDefault(n,0)+1);
        }
        for(int n:arr){
            Integer count=numbers.get(n);
            if(count==null||count<=0) return false;
            numbers.put(n,count-1);
        }
        
        return true;
    }
    
    /*
        T: O(nlogn)
        S: O(1)
    */
    public boolean canBeEqualSort(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target,arr);
    }
}