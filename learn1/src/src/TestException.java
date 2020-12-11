package src;

public class TestException {
    public static void main(String[] args){
        int i = 0;
        String []greetings = {"hello world!","Hello world!!","HELLO WORLD!!!"};
            while(i<4) {
                try {
                    System.out.println(greetings[i++]);
                    //i++;
                    /*当try捕捉到异常时，出现异常后的语句不会被执行，程序将跳到catch块，再执行finall语句块*/
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("数组下标越界异常!");
                } finally {
                    System.out.println("---------------------");
                }
            }
     }
}
