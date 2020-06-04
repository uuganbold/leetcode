class Solution1154 {

    /*
        T: O(1)
        S: O(1)
    */
    public int dayOfYear(String date) {
        String[] dayStrs=date.split("-");
        int year=Integer.parseInt(dayStrs[0]);
        int month=Integer.parseInt(dayStrs[1]);
        int day=Integer.parseInt(dayStrs[2]);
        int ans=0;
        for(int m=1;m<month;m++){
            ans+=30;
            if(m==2){
                if(isLeap(year)){
                    ans-=1;
                }else {
                    ans-=2;
                }
            }else if(m<=7&&m%2==1||m>=8&&m%2==0){
                ans+=1;
            }
        }
        
        ans+=day;
        
        return ans;
    }
    
    private boolean isLeap(int year){
        return (year%4==0&&year%100!=0)||year%400==0;
    }
}