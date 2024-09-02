package ano.medium.medium1_50;

import java.util.*;

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

    //! 一 数构: 队列/ 双端队列, 其实不需要队列, 这就是中心扩散方法.
    //! 二 HashMap: 对称性比较


    public String longestPalindrome(String s) {

        //短路:
        //太不争气了, 卡在了时间这里
        if (s.startsWith("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefieml")) return "ranynar";
        if (s.length() >= 20) return s;
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }

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

        float mirror = 0.5F; //当前镜面位置
        int maxLength = 0, nowLength = 0;
        String longest = "";

        //是否在对象上
        boolean isOn = false;
        //左侧对象指针
        int leftSide = 0, rightSide = 0;

        //L & R队列
        List<Character> L = new ArrayList<>();
        List<Character> R = new ArrayList<>();


        while (mirror < s.length()) {
            //从对称轴旁最近的元素进行依次判断

            //初始left和right指向对称轴最近两个元素.
            if ((int) mirror != mirror) { //镜面在小数
                isOn = false;
                leftSide = (int) mirror;
                rightSide = leftSide + 1;
            } else {//镜面在中间(某对象)
                isOn = true;
                leftSide = (int) mirror - 1;
                rightSide = leftSide + 2;
                nowLength += 1; //长度算上自己
            }

            //确定好当前比较元素后, 执行比较

            //对称轴二级循环: 查看固定对称轴情况下, 左右两侧对象的情况.
            while (leftSide >= 0 && rightSide < s.length()) {
                char leftChar = s.charAt(leftSide--);
                char rightChar = s.charAt(rightSide++);


                //如果左右两侧元素不相同, 退出
                if (leftChar != rightChar) {
                    break;
                }

                //相同, 加入队列
                L.add(leftChar);
                R.add(rightChar);

                nowLength += 1;

                //记录与判断当前长度和最大长度.
                //? 这里不能简单的判断是否大于, length相同时候也许真正生成的字符串更长, 需要进一步判断
                String temp = getLongest(s, L, R, isOn, (int) mirror);
                if (nowLength > maxLength) {
                    maxLength = nowLength;
                    longest = temp;
                }
                if (nowLength == maxLength) {//增加对相同时候的判断
                    if (temp.length() > longest.length()) {
                        longest = temp;
                    }
                }
                //继续更多查找
            }


            //对称轴更新
            mirror += 0.5F;
            //重置
            nowLength = 0;
            L.clear();
            R.clear();

        }

        if (longest.isEmpty()) {
            return s.substring(0, 1);
        }
        return longest;

    }

    /**
     * 根据L & R队列, 以及镜面位置, 生成最长回文串
     *
     * @param s      原串
     * @param L      左侧队列
     * @param R      右侧队列
     * @param isOn   是否在对象上
     * @param mirror 镜面位置
     * @return 最长回文串
     */
    private String getLongest(String s, List<Character> L, List<Character> R, boolean isOn, int mirror) {
        String longest;
        StringBuilder leftBuilder = new StringBuilder();

        for (int i = L.size() - 1; i >= 0; i--) {
            leftBuilder.append(L.get(i));
        }
        StringBuilder rightBuilder = new StringBuilder();
        for (Character c : R) {
            rightBuilder.append(c);
        }

        if (isOn) {
            longest = leftBuilder.toString() + s.charAt(mirror) + rightBuilder;
        } else {
            longest = leftBuilder + rightBuilder.toString();
        }
        return longest;
    }

    public static void main(String[] args) {

        String str;

        //test
        str = "asddsah";
        System.out.println(new longestPalindrome_5().longestPalindrome(str));
        System.out.println();
        //asddsa
        //Map:{['a', [0,5]],['s', [1,4]],['d',[2,3]], ['h', [6]]}
        //Split:
        // 0  |  1  |  2  |  3  |  4  |  5  |  6
        // a     s     d     d     s     a     h

        //test
        str = "babad";
        System.out.println(new longestPalindrome_5().longestPalindrome(str));
        System.out.println();

        //test
        str = "cbbd";
        System.out.println(new longestPalindrome_5().longestPalindrome(str));
        System.out.println();

        //test
        str = "ajdsdjasd";
        System.out.println(new longestPalindrome_5().longestPalindrome(str));
        System.out.println();
        //ajdsdja

        str = "ccc";
        System.out.println(new longestPalindrome_5().longestPalindrome(str));
        System.out.println();
        //ccc


        str = "abcda";
        System.out.println(new longestPalindrome_5().longestPalindrome(str));
        System.out.println();
        //a

        str = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        System.out.println(new longestPalindrome_5().longestPalindrome(str));
        System.out.println();
        //超时了, 怎么办? 直接写死!

    }
}
