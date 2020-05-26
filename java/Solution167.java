class Solution167 {

    /*
        T: O(N)
        S: O(1)
    */
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        while(i<j){
            
            int sum=numbers[i]+numbers[j];
            
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else return new int[]{i+1,j+1};
        }
        throw null;
    }
}