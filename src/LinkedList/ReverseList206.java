package LinkedList;

public class ReverseList206 {
    /**链表部分第3题
     * 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * */
    public ListNode reverseList(ListNode head){
        //pre是cur之前一个节点，方便反转，cur是当前节点
        ListNode pre = null;
        ListNode cur = head;

        //当cur指向null时，遍历结束
        while(cur != null){
            //存储下一个节点
            ListNode temp = cur.next;
            cur.next = pre;
            //先移动pre，后移动cur
            pre = cur;
            cur = temp;
        }

        //遍历结束时cur为空，pre为cur前一个节点，反转完成，返回pre
        return pre;
    }

    public ListNode recursive(ListNode pre, ListNode cur){
        //递归写法
        if (cur == null){
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        //pre = cur;
        //cur = temp;
        return recursive(cur,temp);
    }

    public static void main(String[] args) {
        ReverseList206 reverseList = new ReverseList206();
        int[] a = {1,2,3,4,5,6};
        ListNode head = new ListNode(a);
        //ListNode res = reverseList.recursive(null, head);
        ListNode res  = reverseList.reverseList(head);
        res.printNode();
    }
}
