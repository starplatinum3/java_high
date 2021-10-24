import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
//        System.out.println(1);
        testCalendar();
    }

   static void testCalendar(){
        // 当前系统时间
        long now = System.currentTimeMillis();
        int hour=7;
        int minute=0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
//        设置了 setTimeInMillis ，之后再设置 HOUR_OF_DAY
//        什么的 ，就会把时间往后推进吗，好像也不是 后面有add 的
//
//       gdate = {Gregorian$Date@574} "2021-10-16T00:00:00.000Z"
//       cdate = {Gregorian$Date@574} "2021-10-16T00:00:00.000Z"
//
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // 下次响铃时间
        long nextTime = calendar.getTimeInMillis();
        // 当单次响铃时
        // 当设置时间大于系统时间时
//       设置了 hour ，也不知道是现在时间的之前还是之后，总之就是两天之内
//       如果少了 就加一天
        if (nextTime > now) {
            System.out.println("nextTime : "+nextTime);
        } else {
            // 设置的时间加一天
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            nextTime = calendar.getTimeInMillis();
            System.out.println("nextTime : "+nextTime);
        }
        System.out.println(calendar);
    }
}
