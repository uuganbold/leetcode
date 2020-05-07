import java.util.*;
class Solution1356 {
    
    /*
        T: O(NlogN)
        S: O(N)
    */
    public int[] sortByBitsCustomComparator(int[] arr){
        Integer[] boxed=convertPrimitiveToBoxed(arr);
        
        Arrays.sort(boxed,new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                  int diff= numberOfBits(num1)-numberOfBits(num2);
                 if(diff==0) return num1-num2;
                 else return diff;
             }
        });
        
        return convertBoxedToPrimitive(boxed);
    }
    
    private Integer[] convertPrimitiveToBoxed(int[] arr){
        Integer[] boxed=new Integer[arr.length];
        for(int i=0;i<boxed.length;i++){
            boxed[i]=arr[i];
        }
        return boxed;
    }
    
    private int[] convertBoxedToPrimitive(Integer[] arr){
        int[] prim=new int[arr.length];
        for(int i=0;i<prim.length;i++){
            prim[i]=arr[i];
        }
        return prim;
    }
    
    private int numberOfBits(Integer num){
         int count=0;
         while(num>0){
             count++;
             num=num&(num-1);
         }
         return count;
     }
    
    public int[] sortByBitsStream(int[] arr) {
        Integer[] boxed=Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed,new Comparator<Integer>(){
             public int compare(Integer num1, Integer num2){
                  int diff= numberOfBits(num1)-numberOfBits(num2);
                 if(diff==0) return num1-num2;
                 else return diff;
             }
        });
        
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }
}