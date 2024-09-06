package ano.hard.hard1_100;


import java.util.Objects;
import java.util.Stack;

public class longestValidParentheses_32 {

    //只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度

    //思路
    //! 一 栈记录, 和之前那个括号匹配的类似

    public int longestValidParentheses(String s) {
        //短路
        if (Objects.isNull(s) || s.isEmpty()) return 0;
        if (s.equals("()")) return 2;
        if (s.equals("()()")) return 4;
        if (s.equals("()()()")) return 6;


        //? 1.栈记录

        int res = 0;
        Stack<Integer> stack = new Stack<>();

        //逻辑:
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') { //如果(就压入
                stack.push(i);

            } else { //如果)就取出来看看
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        longestValidParentheses_32 solution = new longestValidParentheses_32();

        String s = "(()";
        System.out.println(solution.longestValidParentheses(s)); // Output: 2

        s = ")()())";
        System.out.println(solution.longestValidParentheses(s)); // Output: 4

    }
}
