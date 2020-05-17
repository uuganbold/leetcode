class Solution1450 {

    /*
        T: O(N)
        S: O(1)
    */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count=0;
        for(int i=0;i<startTime.length;i++){
            if(startTime[i]<=queryTime&&endTime[i]>=queryTime) count++;
        }
        return count;
    }
}