package ano.easy.easy1_100;

import java.util.*;

import static java.util.Optional.ofNullable;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

<<<<<<< HEAD
public class addTwoNumbers_2 {
=======
class Solution {
>>>>>>> origin/main

    //两个 非空 的链表，表示两个非负的整数。
    //它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
    //将两个数相加，并以相同形式返回一个表示 和 的链表
    //除了数字 0 之外，这两个数都不会以 0 开头

    //示例:
    //输入：l1 = [2,4,3], l2 = [5,6,4]
    //输出：[7,0,8]
    //解释：342 + 465 = 807.

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //个人思路
        //1. 加法的特性: 低位相加, 高位进位. 尽可能从低到高位计算
        //2. 思维路线:
        //!一是直接翻转两个链表, 然后从低到高两个指针扫一遍相加. 太呆了, 肯定超时
        //!二是直接从低到高扫描, 不考虑进位直接相加, 而后再处理进位: 由于一个位子的进位最多只会进"1" (999+999=1998), 所以可以用后置指针直接处理进位(通解不表)
        //!三是把链表存起来变成数组, 然后扫描构建, 空间换时间, 试试不行, 会超出范围. 需要优化.
        //!四是上2个双端队列存链表, 最后直接pollFirst()获取第一个元素, 保证位子对齐.

        //? 4. 双端队列 + 进位标志模拟加法

        //短路
        if (l1.next == null && l2.next == null) {
            if (l1.val + l2.val > 9) {
                return new ListNode(l1.val + l2.val - 10, new ListNode(1));
            } else {
                return new ListNode(l1.val + l2.val);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        //双端队列
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        while (l1 != null) {
            q1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            q2.add(l2.val);
            l2 = l2.next;
        }

        while (!q1.isEmpty() || !q2.isEmpty()) {
            int sum = carry + ofNullable(q1.pollFirst()).orElse(0) + ofNullable(q2.pollFirst()).orElse(0);
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        //test:
        //输入：l1 = [2,4,3], l2 = [5,6,4]
        //输出：[7,0,8]
        //解释：342 + 465 = 807.
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
<<<<<<< HEAD
        ListNode res = new addTwoNumbers_2().addTwoNumbers(l1, l2);
=======
        ListNode res = new Solution().addTwoNumbers(l1, l2);
>>>>>>> origin/main
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
        //? 输出：7 0 8

        //test:
        //输入：l1 = [0], l2 = [0]
        //输出：[0]
        l1 = new ListNode(0);
        l2 = new ListNode(0);
<<<<<<< HEAD
        res = new addTwoNumbers_2().addTwoNumbers(l1, l2);
=======
        res = new Solution().addTwoNumbers(l1, l2);
>>>>>>> origin/main
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
        //? 输出：0

        //test:
        //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //输出：[8,9,9,9,0,0,0,1]
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
<<<<<<< HEAD
        res = new addTwoNumbers_2().addTwoNumbers(l1, l2);
=======
        res = new Solution().addTwoNumbers(l1, l2);
>>>>>>> origin/main
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
        //? 输出：8 9 9 9 0 0 0 1

        //test
        //输入：l1 =[2,4,9], l2 =[5,6,4,9]
        //输出：[7,0,4,0,1]
        l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
<<<<<<< HEAD
        res = new addTwoNumbers_2().addTwoNumbers(l1, l2);
=======
        res = new Solution().addTwoNumbers(l1, l2);
>>>>>>> origin/main
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
        //? 输出：7 0 4 0 1
    }
}
