class Solution1184 {

    /*
        T: O(N)
        S: O(1)
    */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total=0;
        for(int i: distance){
            total+=i;
        }
        
        int s=start;
        int d=destination;
        if(start>destination){
            s=destination;
            d=start;
        }
        
        int oneWay=0;
        for(int i=s;i<d;i++){
            oneWay+=distance[i];
        }
        
        int otherWay=total-oneWay;
        
        return Math.min(oneWay,otherWay);
    }
}