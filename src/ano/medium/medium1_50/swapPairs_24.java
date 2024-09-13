package ano.medium.medium1_50;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class swapPairs_24 {

    //两两交换链表中的节点

    //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点
    //你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）

    //输入：head = [1,2,3,4]
    //输出：[2,1,4,3]

    //思路
    //! 一: 我直接开摆, 扫一遍记录到数组后凉凉交换之后再重建
    public ListNode swapPairs(ListNode head) {

        //短路
        if (Objects.isNull(head)) return null;
        if (Objects.isNull(head.next)) return head;

        //copy to Array
        List<Integer> list = new ArrayList<>();
        ListNode p = head;

        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        //Array func
        for (int i = 0; i + 1 < list.size(); i += 2) {
            Integer temp = list.get(i + 1);
            //i -> 前
            list.set(i + 1, list.get(i));
            //i+1 -> 后
            list.set(i, temp);
        }

        //restore
        ListNode resHead = new ListNode();
        ListNode rp = resHead;

        for (Integer integer : list) {
            rp.next = new ListNode(integer);
            rp = rp.next;
        }

        return resHead.next;

    }

}
