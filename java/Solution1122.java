import java.util.*;
class Solution1122 {

    /*
        T: O(n) n-length of arr1
        S: O(max)
    */
    public int[] relativeSortArrayFreqArray(int[] arr1, int[] arr2) {
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]>max) max=arr1[i];
        }
        
        int[] freq=new int[max+1];
        for(int i=0;i<arr1.length;i++){
            freq[arr1[i]]++;
        }
        
        int j=0;
        for(int i=0;i<arr2.length;i++){
            
            int count=freq[arr2[i]];
            
            while(count>0){
                arr1[j++]=arr2[i];
                count--;
            }
            freq[arr2[i]]=0;
        }
        
        for(int i=0;i<=max;i++){
            int count=freq[i];
            while(count>0){
                arr1[j++]=i;
                count--;
            }
        }
        
        return arr1;
    }

    /*
        T: O(n) n-length of arr1
        S: O(max)
    */
    public int[] relativeSortArrayFreqMap(int[] arr1, int[] arr2) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        Map<Integer,Integer> freq=new HashMap<>();
        
        for(int i=0;i<arr1.length;i++){
            freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);
            if(arr1[i]>max) max=arr1[i];
            if(arr1[i]<min) min=arr1[i];
        }
        
        int j=0;
        for(int i=0;i<arr2.length;i++){
            
            int count=freq.getOrDefault(arr2[i],0);
            
            while(count>0){
                arr1[j++]=arr2[i];
                count--;
            }
            
            freq.remove(arr2[i]);
        }
        
        for(int i=min;i<=max;i++){
            int count=freq.getOrDefault(i,0);
            while(count>0){
                arr1[j++]=i;
                count--;
            }
        }
        
        return arr1;
    }

    /*
        T: O(NlogN) - length of arr1
        S: O(M)- length of arr2
    */
    public int[] relativeSortArrayCustomComparator(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }    
        
        Integer[] boxed=Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        
        Arrays.sort(boxed,new Comparator<Integer>(){
            
            public int compare(Integer num1, Integer num2){
                return map.getOrDefault(num1,arr2.length+num1)-map.getOrDefault(num2,arr2.length+num2);
            }
        });
        
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }
}