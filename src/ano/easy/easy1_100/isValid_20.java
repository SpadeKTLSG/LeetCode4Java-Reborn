package ano.easy.easy1_100;

import java.util.EmptyStackException;
import java.util.Stack;

public class isValid_20 {

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    //每个右括号都有一个对应的相同类型的左括号。

    //思路:
    //写烂了的栈标准解法
    //! 一: 标准解法.

    public boolean isValid(String s) {

        //短路
        if (s.length() <= 1) return false;
        if (s.length() % 2 == 1) return false;
        if (!s.startsWith("(") && !s.startsWith("[") && !s.startsWith("{")) return false;

        int i = 0;
        Stack<Character> stack = new Stack<>();

        while (i < s.length()) {

            Character now = s.charAt(i);
            try {
                switch (now) {
                    //左括号压入堆栈
                    case '(':
                    case '[':
                    case '{': {
                        stack.push(now);
                        break;
                    }
                    //右括号为出栈标识
                    case ')': {
                        Character find = stack.pop();
                        if (find != '(') return false;
                        break;
                    }
                    case ']': {
                        Character find = stack.pop();
                        if (find != '[') return false;
                        break;
                    }
                    case '}': {
                        Character find = stack.pop();
                        if (find != '{') return false;
                        break;
                    }
                }
            } catch (EmptyStackException ignored) {
                return false;
            }
            i++;

        }

        return stack.isEmpty();

    }


    public static void main(String[] args) {

        String s;
        s = "){";
        System.out.println(new isValid_20().isValid(s));
        System.out.println();
    }
}
