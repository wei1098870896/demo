package src;

/*created by wzh 2020-08-26 */
/*java.lang.Math提供了一系列静态方法用于科学计算，其方法的参数和返回值类型一般为double。
* 如果需要更强大的数学运算能力，计算高等数学中的相关内容，可以使用apache commons下面的Math类库*/
/*Math类的常用方法:
* abs绝对值，acos，asin，atan，cos，sin，tan三角函数，sqrt平方根
* pow(double a,double b)a的b次幂
* max最大值，min最小值
* ceil(double a)大于a的最大整数
* floor(double a)小于a的最大整数
* random()返回0.0-1.0的随机数[0,1)
* long round(double a)double型的数据a转换成long型(四舍五入)
* toDegrees(double angard)弧度->角度
* toRadians(double angdeg)角度->弧度*/
public class Mathtest {
    public static void main(String[]args){
        System.out.println(Math.ceil(3.2));
        System.out.println(Math.floor(3.2));
        System.out.println(Math.round(3.2));
        System.out.println(Math.round(3.8));
        System.out.println("==========================================");
        System.out.println(Math.abs(-3));
        System.out.println(Math.sqrt(81));
        System.out.println(Math.pow(2,5));
        System.out.println(Math.pow(8,2));
        for(int i =0;i<10;i++){
            System.out.println("第"+i+"个随机数是"+Math.random());
            System.out.println("第"+i+"个随机整数是"+Math.round(Math.random()*10));
        }
    }
}
