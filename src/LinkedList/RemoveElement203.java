package LinkedList;

import java.sql.ResultSet;
import java.util.List;

/**203.链表部分第1题，203.移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * */
public class RemoveElement203 {
    //常规方法
    public ListNode removeElements(ListNode head, int val){
        //先判断头节点是否是指定元素，若是则直接删除
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        ListNode pre = head;
        ListNode now = head.next;
        while(now != null){
            if(now.val == val){
                //若当前位置为目标元素，前一个元素指向当前的后一个元素
                pre.next = now.next;
                //前一个元素的位置不动，因为后一个元素更新了，需要重新进行判断
            } else {
                //当前元素不是目标元素，则前一个元素正常向后移动
                pre = now;
            }
            now = now.next;
        }
        return head;
    }

    //虚拟头节点方法
    public ListNode removeDummyHead(ListNode head, int val){
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode now = head;
        while(now != null){
            if(now.val == val){
                pre.next = now.next;
            } else{
                pre = now;
            }
            now = now.next;
        }
        //返回虚拟头结点的下一个节点，不返回head，因为head可能已经被删除
        return dummyHead.next;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode elem1 = new ListNode(2);
//        ListNode elem2 = new ListNode(6);
//        ListNode elem3 = new ListNode(3);
//        ListNode elem4 = new ListNode(4);
//        ListNode elem5 = new ListNode(5);
//        ListNode elem6 = new ListNode(6);
//        head.next = elem1; elem1.next = elem2; elem2.next = elem3; elem3.next = elem4;
//        elem4.next = elem5; elem5.next = elem6; elem6.next = null;
        //head.printNode();

        int[] arr = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(arr);
        RemoveElement203 removeElement = new RemoveElement203();
        ListNode res = new ListNode();
        //res = removeElement.removeElements(head, 6);
        res = removeElement.removeDummyHead(head,6);
        res.printNode();
    }
}
