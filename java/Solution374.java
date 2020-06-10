/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution374 {
    public int guessNumber(int n) {
        int lo=1;
        int hi=n;
        
        while(lo<=n){
            int mi=lo+(hi-lo)/2;
            int ans=guess(mi);
            if(ans==0){
                return mi;
            }else if(ans>0){
                lo=mi+1;
            }else {
                hi=mi-1;
            }
        }
        
        return -1;
    }

    private int guess(int i){
        return 0;
    }
}