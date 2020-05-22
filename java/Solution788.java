class Solution788 {

    /*
        T: O(1)
        S: O(1)
    */
    public int rotatedDigits(int N) {
        int countUpto=0;
        int countSelf=0;
        
        int n=N+1;
        int[] number=new int[10];
        int i=9;
        while(n>0){
            number[i--]=n%10;
            n/=10;
        }

        boolean stopCountSelf=false;
        for(i=0;i<number.length;i++){
            countUpto+=digitsUpTo(number[i]-1)*Math.pow(digitsUpTo(9),number.length-1-i);
            if(!stopCountSelf){
                countSelf+=digitRotateSelfUpTo(number[i]-1)*
                                    Math.pow(digitRotateSelfUpTo(9),number.length-1-i);
                if(!selfRotateDigit(number[i])){
                    stopCountSelf=true;
                }
            }
            
            if(invalidDigit(number[i])) break;
           
        }
        return countUpto-countSelf;
    }
    
    private boolean selfRotateDigit(int digit){
        return digit==0||digit==1||digit==8;
    }
    
    private boolean invalidDigit(int digit){
        return digit==3||digit==4||digit==7;
    }
    
    private int digitsUpTo(int digit){
        switch(digit){
            case 0: return 1;
            case 1: return 2;
            case 2:
            case 3:
            case 4: return 3;
            case 5: return 4;
            case 6: 
            case 7: return 5;
            case 8: return 6;
            case 9: return 7;
        }
        return 0;
    }
    
    private int digitRotateSelfUpTo(int digit){
        if(digit==0) return 1;
        if(digit>0&&digit<8) return 2;
        if(digit==8||digit==9) return 3;
        return 0;
    }
    
    private int rotate(int n){
        int newNum=0;
        int length=1;
        while(n>0){
            int digit=n%10;
            switch(digit){
                case 0:
                case 1:
                case 8: break;
                case 2: digit=5; break;
                case 5: digit=2; break;
                case 6: digit=9; break;
                case 9: digit=6; break;
                default: return -1;
            }
            newNum=digit*length+newNum;
            length*=10;
            n/=10;
        }
        return newNum;
    }
}