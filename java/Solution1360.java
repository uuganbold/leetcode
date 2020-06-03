class Solution1360 {

    /*
        T:O(1)
        S: O(1)

        TODO: Can be done with java.time api.
    */
    public int daysBetweenDates(String date1, String date2) {
         return Math.abs(daySinceDawnOfCentury(date1)-daySinceDawnOfCentury(date2));
    }
    
    
    private int daySinceDawnOfCentury(String date){
         String[] dateStrs=date.split("-");
         int year=Integer.parseInt(dateStrs[0]);
         int month=Integer.parseInt(dateStrs[1]);
         int day=Integer.parseInt(dateStrs[2]);
         
         int ans=dayTillThisYear(year);
         
         ans+=dayTillThisMonth(year,month);
         ans+=day;
        
        return ans;       
    }
    
    private int dayTillThisYear(int year){
        year=year-1;
        int leapYear=year/4-year/100+year/400;
         
        return year*365+leapYear;
    }
    
    private int dayTillThisMonth(int year, int month){
        int sum=0;
        for(int i=0;i<month;i++){
            if(i==2){
                sum+=28;
            }else{
                sum+=30;
            }
            
            if(i<=7&&i%2==1||i>=8&&i%2==0){
                sum+=1;
            }
        }
        if(month>2&&isLeapYear(year)){
            sum+=1;
        }
        
        return sum;
    }
    
    private boolean isLeapYear(int year){
        return year%4==0&&year%100!=0||year%400==0;
    }
}