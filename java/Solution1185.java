import java.time.*;
class Solution1185 {

    public String dayOfTheWeek(int day, int month, int year) {
         LocalDate date=LocalDate.of(year,month,day);
         DayOfWeek dayOfWeek=DayOfWeek.from(date);
         String name= dayOfWeek.name();
         name=name.substring(0,1)+name.substring(1).toLowerCase();
         return name;
    }
}