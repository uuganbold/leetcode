import java.util.*;
class Solution401 {
    
    /*
        T: O(12*60)
        S: O(1)
    */
    public List<String> readBinaryWatch(int num){
        List<String> ans=new ArrayList<String>();
        
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                if(bitCount((h<<6)|m)==num){
                    StringBuilder time=new StringBuilder();
                    time.append(h).append(":");
                    if(m<10){
                        time.append("0");
                    }
                    time.append(m);
                    ans.add(time.toString());
                }
            }
        }
        
        return ans;
    }
    
    private int bitCount(int n){
        int count=0;
        while(n>0){
            n&=n-1;
            count++;
        }
        return count;
    }
    
    /*
        T:O(10!/5!=252)
        S: O(10) for stack
    */
    public List<String> readBinaryWatchBacktracking(int num) {
        List<Integer> bits=new ArrayList<>();
        generateBits(0,10,num,bits);
        
        List<String> ans=new ArrayList<>();
        for(int b:bits){
            String time=bitToTime(b);
            if(time!=null){
                ans.add(time);
            }
        }
        
        return ans;
    }
    
    private void generateBits(int base, int capacity, int bitCount, List<Integer> ans){
        if(bitCount==0){
             ans.add(base);
             return;
         }
        
        for(int shift=capacity-1;shift>=bitCount-1;shift--){
            generateBits(base|(1<<shift), shift, bitCount-1, ans);
        }
        
    }

    
    private String bitToTime(int bits){
        int hour=bits>>6;
        if(hour>=12) return null;
        
        int minute=bits&(63);
        if(minute>=60) return null;
        
        StringBuilder ans=new StringBuilder();
        ans.append(hour).append(":");
        if(minute<10){
            ans.append("0");
        }    
        
        ans.append(minute);
        return ans.toString();
    }
}