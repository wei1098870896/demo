import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class TestCalendar2 {
    public static void main(String[]args) throws ParseException{
        System.out.println("请输入日期（格式为2020-8-25）");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        System.out.println("您刚刚输入的日期为:"+dateString);
        String [] str = dateString.split("-");
        int year = Integer.parseInt(str[0]);
        int month = new Integer(str[1]);
        int day = new Integer(str[2]);
        Calendar cal = new GregorianCalendar(year, month-1,day);
        cal.set(Calendar.DATE,1);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for(int i =0;i<dow-1;i++){
            System.out.print("\t");
        }
        int maxdate = cal.getActualMaximum(Calendar.DATE);
        System.out.println("maxdate:"+maxdate);
        for(int i=0;i<=maxdate;i++){
            StringBuilder sbu = new StringBuilder();
            if(cal.get(Calendar.DATE)==day)
            {
                sbu.append(cal.get(Calendar.DATE)+"*\t");
            }else{
                sbu.append(cal.get(Calendar.DATE)+"\t");
            }
            System.out.print(sbu);
            if(cal.get(Calendar.DAY_OF_WEEK)==6)
                System.out.print("\n");
            cal.add(Calendar.DATE,1);
        }
    }
}
