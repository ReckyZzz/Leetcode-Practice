package LinkedList;

//Definition for singly-linked list.
class ListNode {
    public int val;

    public ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //尾插法初始化链表
    ListNode(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for(int i = 1; i < array.length; i++){
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        this.val = head.val;
        this.next = head.next;
    }

    void printNode(){
        ListNode item = this;
        while(item != null){
            System.out.println(item.val);
            item = item.next;
        }
    }
}
