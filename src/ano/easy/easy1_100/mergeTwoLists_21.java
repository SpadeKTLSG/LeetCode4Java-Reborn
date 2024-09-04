package ano.easy.easy1_100;


import java.util.Objects;

public class mergeTwoLists_21 {

    //将两个升序链表合并为一个新的 升序 链表并返回
    //新链表是通过拼接给定的两个链表的所有节点组成的

    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]


    //思路
    //!一: 简单模拟即可, 两个指针指向俩个链表

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //短路:
        if (Objects.isNull(list1) && Objects.isNull(list2)) return null;
        if (Objects.isNull(list1)) return list2;
        if (Objects.isNull(list2)) return list1;


        ListNode resHead = new ListNode(114514, null);
        ListNode p1 = list1, p2 = list2;
        ListNode rp = resHead;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                rp.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                rp.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            rp = rp.next;
        }

        rp.next = p2 != null ? p2 : p1;        //余下直接拼接

        return resHead.next;
    }


}
