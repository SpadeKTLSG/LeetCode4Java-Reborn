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
            if (s == null) {
                return "";
            }
        }

        //2. 简单多指针
        int p = 0;
        StringBuilder sb = new StringBuilder();

        while (p < strs.length) {

            if (check(p, strs)) {
                sb.append(strs[0].charAt(p));
            } else {
                break;
            }
            p += 1;

        }
        return sb.toString();
    }

    private boolean check(int p, String[] strs) {

        //null直接返回false
        if (Objects.isNull(strs[0].charAt(p))) {
            return false;
        }
        char c = strs[0].charAt(p);
        for (String s : strs) {
            if (Objects.isNull(s.charAt(p))) {
                return false;
            }
            if (s.charAt(p) != c)
                return false;
        }
        return true;
    }
}
