import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*DateFormat类的作用，把时间对象转化成指定格式的字符串，反之，把指定格式的字符串转化成时间对象。
* DateFormat是一个抽象类，我们一般是用他的子类SimpleDateFormat类来实现。*/
public class TestDate {
    public static void main(String[]args){
        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd");
        //将时间对象转化成字符串
        String daytime = sd1.format(new Date());
        System.out.println(daytime);
        System.out.println(sd2.format(new Date()));
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
        System.out.println("**************************************************");
        /*将指定格式的字符串转化成时间对象，字符串格式需要和指定格式一致*/
        String time1 = "2020-08-25";
        Date date = null;
        try {
            date = sd2.parse(time1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("date1:"+date);
        time1 = "2020-08-25 10:40:30";
        Date date1 = null;
        try {
            date1 = sd1.parse(time1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("date2:"+date1);
        SimpleDateFormat sss = new SimpleDateFormat("D");
        String days = sss.format(new Date());
        System.out.println("**************************************************");
        System.out.println(days);//一年中的天数
        System.out.println(new SimpleDateFormat("M").format(new Date()));//一年中的月份数
        System.out.println(new SimpleDateFormat("W").format(new Date()));//一年中的周数
        System.out.println(new SimpleDateFormat("w").format(new Date()));//一月中的周数
        System.out.println(new SimpleDateFormat("F").format(new Date()));//月份中的星期数
        System.out.println(new SimpleDateFormat("E").format(new Date()));//星期中的天数
        System.out.println(new SimpleDateFormat("z").format(new Date()));//时区




    }
}
