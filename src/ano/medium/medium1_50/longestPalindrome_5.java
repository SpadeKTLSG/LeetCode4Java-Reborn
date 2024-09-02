package ano.medium.medium1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class longestPalindrome_5 {

    //找到 s 中最长的回文子串
    //输入：s = "babad"
    //输出："bab"
    //解释："aba" 同样是符合题意的答案

    //思路:
    //回文串我一般会想到直接用数据结构来解决.
    //首先需要抓住对应数据结构的特征: 回文意味着, 以一个镜面为对称轴, 其左右两侧的内容是equal
    //可能先想到的会是进来一个后直接再扫描构建一次之前的已经cache的序列.
    //如果说不用队列, 似乎可以用HashMap判断: 存储下串中的所有元素的下标映射关系, 然后从左到右以0.5 + X为对称轴扫一次
    //如果 max < 2, 那么就看看有没有相同的相邻对象, 标记为2 (保底), 再没有就是1

    //! 一 数构: 队列/ 双端队列
    //! 二 HashMap: 对称性比较


    public String longestPalindrome(String s) {




        //一: Hash想法
      /*  HashMap<Character, List<Integer>> map = new HashMap<>();
        //存储下串中的所有元素的下标映射关系
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(c, indices);
            }
        }

        float mirror = 0.5F; //当前镜面位置
        int maxLength = 0, nowLength = 0;
        String longest = "";

        //左侧对象指针
        int leftSide = 0, rightSide = 0;

        while (mirror < s.length()) {
            //从对称轴旁最近的元素进行依次判断

            //初始left和right指向对称轴最近两个元素.
            if ((int) mirror != mirror) { //镜面在小数
                leftSide = (int) mirror;
                rightSide = leftSide + 1;
            } else {//镜面在中间
                leftSide = (int) mirror - 1;
                rightSide = leftSide + 2;
            }

            //确定好当前比较元素后, 执行比较

            //对称轴二级循环: 查看固定对称轴情况下, 左右两侧对象的情况.
            //? 感觉咩有意义了, 这样走的话不如不用map... 根本没起到作用.


            //记录与判断当前长度和最大长度.

            //对称轴更新
            mirror += 0.5F;
        }
*/


        //二: 镜面List
        //基本是仿照Python的做法, 镜面分割后用List模拟单向普通队列L & R. 每次p, q指针从队列镜面处开始增长.
        //其他基本思考自己Python的解法模拟的
    }

    public static void main(String[] args) {

        String str;
        str = "asddsah";
        System.out.println(new longestPalindrome_5().longestPalindrome(str));
        System.out.println();
        //asddsa
        //Map:{['a', [0,5]],['s', [1,4]],['d',[2,3]], ['h', [6]]}
        //Split:
        // 0  |  1   2   3   4   5   6
        // a     s    d    d    s    a    h
    }
}
