package ano.easy.easy1_100;

import java.util.Objects;

public class isPalindrome_9 {

    //一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false
    //回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数

    //思路
    //! 没有思路, 直接干!
    public boolean isPalindrome(int x) {
        return Objects.equals(String.valueOf(new StringBuilder(String.valueOf(x)).reverse()), String.valueOf(x));
    }
}
