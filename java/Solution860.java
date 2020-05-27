class Solution860 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean lemonadeChange(int[] bills) {
        int bill5=0;
        int bill10=0;
        
        for(int bill:bills){
            switch(bill){
                case 5: bill5++; break;
                case 10:{
                    if(bill5==0) return false;
                    bill10++;
                    bill5--;
                    break;
                }
                case 20: {
                    if(bill10>0){
                        if(bill5==0) return false;
                        bill10--;
                        bill5--;
                    }else{
                        if(bill5<3) return false;
                        bill5-=3;
                    }
                }
            }
        }
        
        return true;
    }
}