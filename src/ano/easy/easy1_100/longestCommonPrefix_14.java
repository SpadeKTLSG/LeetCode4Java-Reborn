package ano.easy.easy1_100;

import java.util.Objects;

public class longestCommonPrefix_14 {

    //查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""

    //思路
    //! 一 字典. 将各个字符串 -> (char : sit), 然后查找匹配
    //! 二 多指针. 很简单的多个指针指向各自的前面第一位. 然后能往前就往前(同步)
    public String longestCommonPrefix(String[] strs) {


        //短路
        if (Objects.isNull(strs)) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (String s : strs) {
            if (Objects.isNull(s)) {
                return "";
            }
        }

        //2. 简单多指针
        int p = 0;
        StringBuilder sb = new StringBuilder();

        while (p < strs[0].length() && check(p, strs))
            sb.append(strs[0].charAt(p++));

        return sb.toString();
    }


    private boolean check(int p, String[] strs) {

        //校验做好
        if (p >= strs[0].length()) {
            return false;
        }
        char c = strs[0].charAt(p);
        for (String s : strs) {
            if (p >= s.length() || s.charAt(p) != c) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String[] strs;
        strs = new String[]{"", ""};
        System.out.println(new longestCommonPrefix_14().longestCommonPrefix(strs));
        System.out.println();


        strs = new String[]{"flower", "flower", "flower", "flower"};
        System.out.println(new longestCommonPrefix_14().longestCommonPrefix(strs));
        System.out.println();
    }
}
