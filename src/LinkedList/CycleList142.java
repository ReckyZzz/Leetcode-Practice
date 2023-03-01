package LinkedList;

public class CycleList142 {
    /**链表部分第6题
     * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 不允许修改 链表。
     * */
    public ListNode detectCycle(ListNode head){
        ListNode fast, slow;
        fast = head;
        slow = head;
        while(fast != null && fast.next != null){
            //快指针一次移动两个位置，慢指针一次移动一个位置
            fast = fast.next.next;
            slow = slow.next;
            //当快慢指针相遇
            if(fast == slow){
                //当快慢指针相遇时，他们走到环的起点的路程=从head到环起点的路程
                ListNode index1 = fast;
                ListNode index2 = head;
                while(index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index2;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
