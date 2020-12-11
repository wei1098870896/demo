
/*包装类的主要用途
1.作为和基本数据类型对应的类，方便涉及到对象的操作，如Objective[]、集合等的操作
2.包含每种基本数据类型的相关属性如最大值最小值等，以及相关的操作方法（这些操作方法的作用是在基本数据类型，包装类对象，字符串之间提供相互转化的方法）*/
public class WrapperClass {
    public static void main(String[] args){
        //Integer i = new Integer(10);
        //Integer j = new Integer(50);
        Integer i = Integer.valueOf(20);
        Integer j = Integer.valueOf(50);
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("-----------------------");
        int a = i.intValue();
        System.out.println("a="+a);
        Integer k = Integer.parseInt("234");
        Integer l = new Integer("999");
        String s1 = k.toString();
        System.out.println("k="+k);
        System.out.println("l="+l);
        System.out.println("s="+s1);
        System.out.println("int能表示的最大整数："+Integer.MAX_VALUE);
        System.out.println("short能表示的最大整数："+Short.MAX_VALUE);
    }
}
