package LinkedList;

/**链表部分第5题，19.删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * */
public class DeleteLastNth19 {

    public ListNode remove(ListNode head, int n){
        //快慢指针，快指针先走n+1步，当快指针指向null时，慢指针指向倒数第n+1个节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        //快指针先走n+1步
        for(int i = 0; i < n + 1; i++){
            fast = fast.next;
        }
        //移动快慢指针，循环结束时快指针为空，则慢指针指向倒数第n+1个元素
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //删除元素
        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        DeleteLastNth19 deleteLastNth = new DeleteLastNth19();
        int[] a = {1,2,3,4,5,6};
        ListNode head = new ListNode(a);
        ListNode res  = deleteLastNth.remove(head,2);
        res.printNode();
    }
}
