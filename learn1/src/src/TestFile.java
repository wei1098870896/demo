package src;
import java.io.*;
import java.util.*;
public class TestFile {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("亚索",75000,1987,12,15);
        staff[1] =new Employee("易大师",50000,1989,10,1);
        staff[2] =new Employee("古拉加斯",130000,1994,10,25);
        staff[2].raiseSalary(50.0);
        System.out.println(staff[2].toString());
        try
        {
            //save all employee records to the file employee.dat
            PrintWriter out = new PrintWriter("employee.dat");
            writeDate(staff,out);
            out.close();
            //retrieve all records to a new array
            Scanner in = new Scanner(new FileReader("employee.dat"));
            Employee[] newStaff = readData(in);
            in.close();
            //print the newly employee records
            for(Employee e:newStaff){
                System.out.println(e);
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }

    }
    /*TestFile公共类的私有方法定义*/
    /*Function one
    * Writes all employees in an array to a print writer
    * @param employees an arry of employees
    * @param out a print writer*/
    private static void writeDate(Employee[] employees,PrintWriter out){
        //输出总的雇员数量
        out.println("雇员数量="+employees.length);
        for(Employee e : employees){
            e.writeData(out);
        }
    }
    /*Function two
    * Reads an array of employees from a scanner
    * @param in the scanner
    * @return the array of employees*/
    private static Employee[] readData(Scanner in){
        //retrieve the size of array
        int n = in.nextInt();
        in.nextInt();

        Employee [] employees =new Employee[n];
        for(int i =0;i<n;i++){
            employees[i] = new Employee();
            employees[i].readData(in);
        }
        return employees;
    }
}
    /*雇员类的定义，包括私有的成员变量和公共的基本的方法*/
    class Employee{
        private String name;
        private double salary;
        private Date hireDay;

        public Employee()
        {
            System.out.println("Employee的无参构造函数");
        }
        public Employee(String n,double s,int year,int month,int day){
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
        public void raiseSalary(Double byPercent){
            double raise = salary * byPercent/100;
            salary +=raise;
        }
        public String toString(){
            return getClass().getName()+"[name=" + name + ",salary="+salary + ",hireDay="+hireDay +"]";
        }
        public void writeData(PrintWriter out){
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(hireDay);
            out.println(name + "|" + salary + "|"+ calendar.get(Calendar.YEAR) + "|" +calendar.get(Calendar.MONTH+1) + "|" +calendar.get(Calendar.DAY_OF_MONTH));
        }
        public void readData(Scanner in){
            String line = in.nextLine();
            String[] tokens = line.split("\\|");
            /*为了读入记录，我们每读入一行，然后分离所有的域。我们使用一个扫描器来读入每一行，然后用String.split方法将这一行断开成一组标记*/
            /*split方法的参数是一个描述分隔符的正则表达式，碰巧的是，竖线在正则表达式中具有特殊的含义，因此它需要用\字符来转义，而这个\又需要另一个\来转义，这样就产生了"\\|"表达式。*/
            name = tokens[0];
            salary = Double.parseDouble(tokens[1]);
            int y = Integer.parseInt(tokens[2]);
            int m = Integer.parseInt(tokens[3]);
            int d = Integer.parseInt(tokens[4]);
            GregorianCalendar calendar = new GregorianCalendar(y,m-1,d);
            hireDay = calendar.getTime();
        }
    }

