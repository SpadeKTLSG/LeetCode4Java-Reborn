package ano.medium.medium1_50;

public class reverseInt_7 {

    //32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    //如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
    //假设环境不允许存储 64 位整数(有符号或无符号)

    //思路
    //! 一: 我能想到的API方法, 直接处理一下符号位等东西直接就能出来
    //! 二: 其他的算了, 那些手动写的位子转换的对于我数学超纲了
    public int reverse(int x) {

        String s = String.valueOf(x);

        //短路
        if (s.length() == 1) {
            return x;
        }


        //? 1.基础JavaAPI方法

        //符号位
        boolean isNegative = false;
        if (s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
        }

        //反转
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        String reverse = stringBuilder.toString();

        //去掉前导0
        int i = 0;
        while (reverse.charAt(i) == '0') {
            i++;
        }
        reverse = reverse.substring(i);

        //判断是否溢出
        if (reverse.length() > 10) {
            return 0;
        }
        if (reverse.length() == 10) {
            if (isNegative) {
                if (reverse.compareTo("2147483648") > 0) {
                    return 0;
                }
            } else {
                if (reverse.compareTo("2147483647") > 0) {
                    return 0;
                }
            }
        }

        //拼接
        if (isNegative) {
            reverse = "-" + reverse;
        }
        return Integer.parseInt(reverse);


    }
}
