import java.util.*;

class Solution1507 {
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>() {
            {
                put("Jan", "01");
                put("Feb", "02");
                put("Mar", "03");
                put("Apr", "04");
                put("May", "05");
                put("Jun", "06");
                put("Jul", "07");
                put("Aug", "08");
                put("Sep", "09");
                put("Oct", "10");
                put("Nov", "11");
                put("Dec", "12");
            }
        };
        String[] arr = date.split(" ");
        String day = arr[0].substring(0, arr[0].length() - 2);
        if (day.length() < 2) {
            day = "0" + day;
        }
        return arr[2] + "-" + months.get(arr[1]) + "-" + day;
    }
}