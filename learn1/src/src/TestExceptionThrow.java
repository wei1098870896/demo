package src;

public class TestExceptionThrow {
    public static int quotient(int x,int y) throws MyException
    {
        if(y<0)
        {
            throw new MyException("除数不能为负数！");
        }
        return x/y;
    }
    public static void main(String[]args)
    {
        int x=8;
        int y=-1;
        try {
            double result = quotient(x,y);
        }catch (MyException e)
        {
            System.out.println(e.getMessage());
        }catch (ArithmeticException e)
        {
            System.out.println("除数不能为0");
        }catch (Exception e)
        {
            System.out.println("程序发生了其他异常！");
        }
    }
}
/*创建自定义异常类*/
class MyException extends Exception{
    String message;
    public MyException(String ErrorMessage){//重写有参构造函数
        message = ErrorMessage;
    }
    public String getMessage(){
        return message;
    }
}
/*Hanabi  River  Tank  Unified  Kaiwing    Nuguri Canyon  showmaker Ghost BeryL
* Doran  Pyosik  Chovy Deft  Keria */
/*Java常见异常
* 在java中提供了一些异常用来描述经常发生的错误，对于这些异常，
* 有的需要程序员进行捕捉处理或声明抛出，有的是由java虚拟机自动进行捕捉处理。
* java中常见的异常类:
* *1.RuntimeException子类
      java.lang.ArrayIndexOutOfBoundsException
    * 数组索引越界异常。当对数组的索引值为负数或者大于等于大小时抛出。
    * java.lang.ArithmeticException
    * 算出条件异常，比如除数为0等。
    * java.lang.NullPointerException
    * 空指针异常，当应用试图在要求适用对象的地方是使用了null时，抛出该异常。譬如，调用null对象的实例方法，
    * 访问null对象的属性，计算null对象的长度，使用throw语句抛出null等等
    * java.lang.ClassNotFoundException
    * 找不到类异常，当应用试图根据字符串形式的类名构造类，而在便利CLASSPATH之后找不到对应名称的class文件时，抛出异常。/
    *java.lang.NegativeArraySizeException 数组长度为负值
    *java.lang.SecurityException 安全性异常
    * java.lang.IllegalArgumentEXception 非法参数异常
   2.IOException
   * IOException操作输入流和输出流时可能出现的异常
   * EOFException 文件已结束异常
   * FileNotFoundException 文件未找到异常
   3.其他
   * ClassCastException类型转换异常
   * ArrayStoreException 数组中包含不兼容的值抛出异常
   * SQLException 数据库操作异常
   * NoSuchFiledException 字段未找到异常
   * NoSuchMethodException 方法未找到异常
   * NumberFormatException 字符串转换为数字抛出的异常
   * StringIndexOutOfBoundsException 字符串索引超出范围抛出的异常
   * IllegalAccessException 不允许访问某类异常
   * InstantitationException 当应用程序试图使用class类中的newInstance()方法创建一个类的实例，
   * 而指定的类对象无法被实例化时，抛出异常
自定义异常
* 创建自定义异常类一般会选择继承Exception和RuntimException，如果不要求调用者一定要处理抛出的异常，就继承RuntimeException
* 在方法中通过throw关键字抛出异常对象。如果在当前抛出异常的方法中处理异常，可以使用try-catch语句捕获并处理，否则在方法的声明处
* 通过throw关键字指明要抛出给的方法调用者的异常，继续进行下一步操作。
 */
/*亚托克斯，格雷福斯，阿兹尔，赛娜，诺提勒斯-----纳尔，奥利安娜，烬，蕾欧娜
LGD 奥恩，千珏，辛德拉，烬，蕾欧娜 ------------ 凯尔，李青，奥利安娜，赛娜，瑟提 Rainbow7
*/