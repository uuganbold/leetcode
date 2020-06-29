class Solution1491 {

    /*
        T: O(N)
        S: O(1)
    */
    public double average(int[] salary) {
        int max=0;
        int min=Integer.MAX_VALUE;
        double sum=0.0;
        for(int s:salary){
            if(s>max){
                max=s;
            }
            if(s<min){
                min=s;
            }
            sum+=s;
        }
        
        return (sum-max-min)/(salary.length-2);
    }
}