package LinkedList;

/**链表部分第4题，24.两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * */
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        //虚拟头节点
        while(cur.next != null && cur.next.next != null){
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            //temp为node2后面的节点
            ListNode temp = cur.next.next.next;
            //两个节点交换
            cur.next = node2;
            node2.next = node1;
            node1.next = temp;
            //cur向后移动
            cur = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        SwapPairs24 swapPairs = new SwapPairs24();
        int[] a = {1,2,3,4,5,6};
        ListNode head = new ListNode(a);
        ListNode res  = swapPairs.swapPairs(head);
        res.printNode();
    }
}
