/*
* 自动装箱和自动拆箱就是将基本数据类型和包装类之间进行在自动的相互转换。JDK1.5之后引入了自动装箱(autoboxing)和拆箱(unboxing)
* 因此只需Integer i = 5这样的语句就能实现基本数据类型转换成包装类，这是因为JVM为我们执行了Integer i = Integer.valueOf(5)这样的操作，这就是Java的自动装箱
* 总结：自动装箱是通过调用包装类的valueof()方法实现的，而自动拆箱过程是通过调用xxxValue()方法实现的，例如intValue(),DoubleValue()*/
public class AutoBoxing {
    public static void main(String[]args) {
        Integer i = 100;//自动装箱
        //相当于编译器作自动的语法编译
        Integer i1 = Integer.valueOf(100);
        int j1 = i1;//自动拆箱
        //相当于编译器的语法编译
        int j2 = i.intValue();
        test1();
    }
        /*包装类的缓存问题*/
        static void  test1()
        {
            Integer i1 = -128;
            Integer i2 = -128;
            System.out.println(i1 == i2);
            System.out.println("i1.equals(i2)=[" + i1.equals(i2) + "]");
            Integer in3 = 1234;
            Integer in4 = 1234;
            System.out.println(in3 == in4);//false 因为1234不在缓存范围内
            System.out.println(in3.equals(in4));//true
        }

}
