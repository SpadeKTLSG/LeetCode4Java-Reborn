package ano.medium.medium1_50;

import java.util.Objects;

public class removeNthFromEnd_19 {

    //19. 删除链表的倒数第 N 个结点
    //删除链表的倒数第 n 个结点，并且返回链表的头结点

    //思路
    //! 正着扫一遍, 同时将链表倒置过来. 这个时候正向遍历到的第N个节点就是原先倒数第N个节点. 然后再重新构建? 但是这样太蠢了不如不做
    //! 一: wssb, 直接扫描一遍记录长度, 然后再来一遍

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //短路
        if (Objects.isNull(head)) return null;
        if (Objects.isNull(head.next) && n == 1) return null;

        //? 1.扫一遍, 再扫一遍
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length += 1;
            p = p.next;
        }

        length = length - n;

        // 短路删除头
        if (length == 0) {
            return head.next;
        }

        p = head;
        while (length > 1) {
            p = p.next;
            length -= 1;
        }
        p.next = p.next.next;

        return head;
    }

    public static void main(String[] args) {
        // Test case 1
        ListNode head1 = new removeNthFromEnd_19().createLinkedList(new int[]{1, 2, 3, 4, 5});
        int n1 = 2;
        ListNode result1 = new removeNthFromEnd_19().removeNthFromEnd(head1, n1);
        new removeNthFromEnd_19().printLinkedList(result1); // Expected output: [1, 2, 3, 5]

        // Test case 2
        ListNode head2 = new removeNthFromEnd_19().createLinkedList(new int[]{1});
        int n2 = 1;
        ListNode result2 = new removeNthFromEnd_19().removeNthFromEnd(head2, n2);
        new removeNthFromEnd_19().printLinkedList(result2); // Expected output: []

        // Test case 3
        ListNode head3 = new removeNthFromEnd_19().createLinkedList(new int[]{1, 2});
        int n3 = 1;
        ListNode result3 = new removeNthFromEnd_19().removeNthFromEnd(head3, n3);
        new removeNthFromEnd_19().printLinkedList(result3); // Expected output: [1]


    }


    private ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    private void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

}
