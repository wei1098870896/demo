
import javax.xml.crypto.Data;
import java.io.*;
import java.time.Year;
import java.util.*;
public class RandomFileTest {
    public static void main(String[]args){
        Employee2[] staff = new Employee2[3];
        staff[0] =new Employee2("亚索",75000,1987,12,15);
        staff[1] =new Employee2("易大师",50000,1989,10,1);
        staff[2] =new Employee2("古拉加斯",130000,1994,10,25);
        try
        {
            //save all employee records to the file employee2.dat
            DataOutputStream out = new DataOutputStream(new FileOutputStream("empolyee2.dat"));
            for(Employee2 e:staff)
                e.writeData(out);
            out.close();
            //retrieve all records into a new array
            RandomAccessFile in = new RandomAccessFile("employee2.dat","r");
            //compute the size of array
            int n = (int)(in.length()/Employee2.RECORD_SIZE);
            Employee2 [] newstaff = new Employee2[n];
            //read employee2s in reverse order
            for(int i = n-1;i>=0;i--){
                newstaff[i] = new Employee2();
                in.seek(i*Employee2.RECORD_SIZE);
                newstaff[i].readData(in);
            }
            in.close();
            //print the newly read employee2 records
            for(Employee2 e:newstaff){
                System.out.println(e);
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }

}
class Employee2
{
    private String name;
    private double salary;
    private Date hireDay;
    public static final int NAME_SIZE =40;
    public static final int RECORD_SIZE = 2* NAME_SIZE + 8 + 4 + 4 + 4;
    public Employee2(){

    }
    public Employee2(String n,double s, int year,int month,int day){
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        hireDay = calendar.getTime();
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public Date getHireDay(){
        return hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent/100;
        salary += raise;
    }
    public String toString()
    {
        return getClass().getName()
                + "[name=" + name
                + ",salary=" + salary
                + ",hireDay=" + hireDay
                + "]";
    }
    /*Writes employee2 data to a data output
    * @param out the data output */
    public void writeData(DataOutput out) throws IOException
    {

        DataIO.writeFixedString(name,NAME_SIZE,out);

        out.writeDouble(salary);

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(hireDay);
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH)+1);
        out.writeInt((calendar.get(Calendar.DAY_OF_MONTH)));
    }
    public void readData(DataInput in)
        throws IOException
    {
        name = DataIO.readFixedString(NAME_SIZE,in);
        salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        GregorianCalendar calendar = new GregorianCalendar(y,m-1,d);
        hireDay = calendar.getTime();
    }
}
class DataIO
{
    public static String readFixedString(int size,DataInput in)
        throws IOException
    {
        StringBuilder b = new StringBuilder(size);
        int i = 0;
        boolean more = true;
        while (more && i < size) {
            char ch = in.readChar();
            i++;
            if (ch == 0) more = false;
            else b.append(ch);
        }
        in.skipBytes(2 * (size - 1));
        return b.toString();

    }
    public static void writeFixedString(String s ,int size,DataOutput out)
        throws IOException
    {
        for(int i=0;i<size;i++){
            char ch = 0;
            if(i<s.length()) ch = s.charAt(i);
            out.writeChar(ch);
        }
    }
}