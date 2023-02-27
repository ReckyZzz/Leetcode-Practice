package LinkedList;

public class DesignList707 {
    /**链表部分第2题
     * 设计链表的实现
     * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
     * 0 <= index, val <= 1000
     * */
    public int size;
    //head是虚拟头结点
    public ListNode head;
    public DesignList707() {
        size = 0;
        head = new ListNode(0);
    }

    //获取第n个结点的值
    public int get(int index) {
        if(index >= size){
            return -1;
        }
        ListNode cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        //有虚拟头结点，现在cur的位置为n-1，要找的是n，所以还要取next
        return cur.next.val;
    }

    //头部插入节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //尾部插入节点
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    //第n个元素之前插入元素
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        size++;
        ListNode cur = head;
        //cur找到的是第n-1个节点，cur.next才是第n个节点
        //运行index次，找到前驱节点
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
    }

    //删除第n个元素
    public void deleteAtIndex(int index) {
        if(index >= size){
            return;
        }
        size--;
        ListNode cur = head;
        //cur找到的是第n-1个节点，cur.next才是第n个节点
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    public static void main(String[] args) {
        DesignList707 list = new DesignList707();
        int index = 5;
        int param1 = list.get(index);
    }
}
