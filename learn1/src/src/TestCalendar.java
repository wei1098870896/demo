package src;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*Calendar类是一个抽象类，为我们提供了关于日期计算的相关功能，例如年，月，日，时，分，秒的展示和计算。
* GregorianCalendar是Calendar的一个具体子类，提供了世界上大多数地区使用的标准日历系统。*/
public class TestCalendar {
    public static void main(String[]args)
    {
        GregorianCalendar gc1 = new GregorianCalendar(2020,8,25,13,54,50);
        int year = gc1.get(Calendar.YEAR);
        int month = gc1.get(Calendar.MONTH);
        int day = gc1.get(Calendar.DAY_OF_MONTH); // 打印：9
        int day2 = gc1.get(Calendar.DATE); // 打印：9
        // 日：Calendar.DATE和Calendar.DAY_OF_MONTH同义
        int date = gc1.get(Calendar.DAY_OF_WEEK); // 打印：3
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(day2);
        System.out.println(date);
        System.out.println("****************************************");
        GregorianCalendar calendar2 = new GregorianCalendar();
        calendar2.set(Calendar.YEAR, 2020);
        calendar2.set(Calendar.MONTH, Calendar.AUGUST); // 月份数：0-11
        calendar2.set(Calendar.DATE, 25);
        calendar2.set(Calendar.HOUR_OF_DAY, 14);
        calendar2.set(Calendar.MINUTE, 06);
        calendar2.set(Calendar.SECOND, 23);
        printCalendar(calendar2);
        // 日期计算
        GregorianCalendar calendar3 = new GregorianCalendar(2999, 10, 9, 22, 10, 50);
        calendar3.add(Calendar.MONTH, -7); // 月份减7
        calendar3.add(Calendar.DATE, 7); // 增加7天
        printCalendar(calendar3);
        // 日历对象和时间对象转化
        Date d = calendar3.getTime();
        GregorianCalendar calendar4 = new GregorianCalendar();
        calendar4.setTime(new Date());
        long g = System.currentTimeMillis();
    }
    static void printCalendar(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 星期几
        String week = "" + ((date == 0) ? "日" : date);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.printf("%d年%d月%d日,星期%s %d:%d:%d\n", year, month, day,
                week, hour, minute, second);
    }
}
