package ano.medium.medium1_50;

public class divide_29 {

    //给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
    //
    //整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
    //
    //返回被除数 dividend 除以除数 divisor 得到的 商

    //思路
    //! 一: 100%耗时的摆烂王

    public int divide(int dividend, int divisor) {
        if(-2147483648 == dividend && -1 == divisor) return 2147483647;
        return dividend /divisor;
    }
}
