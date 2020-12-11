package src;

import java.util.Date;

public class DateTime {
    public static void main(String[] args){
        Date date1 = new Date();
        System.out.println(date1.toString());
        long li = date1.getTime();
        Date date2 = new Date(li - 1000);
        Date date3 = new Date(li+1000);
        System.out.println(date1.after(date2));
        System.out.println(date1.before(date2));
        System.out.println(date2.after(date3));
        System.out.println(date2.before(date3));
        System.out.println(date1.equals(date3));
        System.out.println(new Date(1000L *60 *60 *24 *365 *39L).toString());
    }
}
