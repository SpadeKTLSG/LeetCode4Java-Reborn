package ano.easy.easy1_100;

import java.util.Stack;

public class lengthOfLongestSubstring_3 {

    //字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3

    public int lengthOfLongestSubstring(String s) {
        //个人思路:
        //!1. 标解滑动窗口, 过一下
        //!2. 栈实现, 遇到相同栈内元素则刷新并记录, 取最大值

        //2.栈实现:
        Stack<Character> stack = new Stack<>();
        int maxLength = 0;
        int nowLength = 0;
        char[] sc = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (stack.search(sc[i]) == -1) { //找不到, 进来
                nowLength += 1;
                stack.push(sc[i]);
            }
            //找到了, 比较最大值
            if(nowLength>maxLength) maxLength=nowLength;
            nowLength = 1;
            stack.clear();
            stack.push(sc[i]);
        }


        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new lengthOfLongestSubstring_3().lengthOfLongestSubstring(s));
    }
}
