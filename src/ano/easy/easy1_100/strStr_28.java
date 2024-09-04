package ano.easy.easy1_100;

public class strStr_28 {


    //给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
    //如果 needle 不是 haystack 的一部分，则返回  -1


    //思路
    //KMP? 也许直接调API即可
    //! 一 随心所欲
    //! 二, 根据长度多种切分Str数组, 脱裤子放屁

    public int strStr(String haystack, String needle) {

        //? 一 啊这, API
        return haystack.indexOf(needle);


    }
}
