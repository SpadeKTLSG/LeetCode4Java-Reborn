package ano.easy.easy1_100;

import java.util.ArrayDeque;
import java.util.Queue;

public class lengthOfLongestSubstring_3 {

    //字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3

    public int lengthOfLongestSubstring(String s) {
        //个人思路:
        //!1. 标解滑动窗口, 过一下
        //!2. 队列实现, 遇到相同队列内元素则刷新并记录, 取最大值


        //短路

        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2 && s.toCharArray()[0] == s.toCharArray()[1]) {
            return 1;
        }
        if (s.length() == 2 && s.toCharArray()[0] != s.toCharArray()[1]) {
            return 2;
        }

        //2.队列实现:
        Queue<Character> queue = new ArrayDeque<>();
        int maxLength = 0;
        char[] sc = s.toCharArray();
        char c;
        for (int i = 0; i < s.length(); i++) {
            if (queue.contains(sc[i])) {  //出队直到当前队尾的和sc[i]相同
                do {
                    c = queue.poll();
                } while (c != sc[i]);
            }
            queue.add(sc[i]);
            if (queue.size() > maxLength) maxLength = queue.size();
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s;
        s = "abcabcbb";
        System.out.println(new lengthOfLongestSubstring_3().lengthOfLongestSubstring(s));

        s = "aab";
        System.out.println(new lengthOfLongestSubstring_3().lengthOfLongestSubstring(s));

        s = "dvdf";
        System.out.println(new lengthOfLongestSubstring_3().lengthOfLongestSubstring(s));
    }
}
