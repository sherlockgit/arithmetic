package linear;

/**
 * Created with IntelliJ IDEA.
 * Description: 双向链表结构
 * User: sherlock
 * Date: 2018-07-23
 */
public class DoubleLink<T> {

    /**
     * 表头
     */
    private Node<T> head;

    /**
     * 链表长度
     */
    private int count;

    /**
     * 双向链表的节点结构
     * @param <T>
     */
    private class Node<T> {

        /**
         * 当前节点的前一个节点
         */
        public Node prev;

        /**
         * 当前节点的后一个节点
         */
        public Node next;

        /**
         * 当前节点的值
         */
        public T value;

        /**
         * 构造函数
         * @param value
         * @param prev
         * @param next
         */
        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    // 构造函数
    public DoubleLink() {
        // 创建“表头”。注意：表头没有存储数据！
        head = new Node<T>(null, null, null);
        head.prev = head.next = head;
        // 初始化“节点个数”为0
        count = 0;
    }

    /**
     * 获取某位置节点
     * @param index
     * @return
     */
    private Node<T> getNode(int index) {

        /*当index小于0或者越界时抛出异常*/
        if (index < 0 || index>=count) {
            throw new IndexOutOfBoundsException();
        }

        /*从表头正向查找*/
        if (index <= count/2) {
            Node<T> node = head.next;
            for (int i = 0; i<index;i++) {
                node = node.next;
            }
            return node;
        }

        /*从表头反向查找*/
        Node<T> node = head.prev;
        index = count - index - 1;
        for (int j = 0; j<index; j++) {
            node = node.prev;
        }
        return node;
    }

    /**
     * 将节点插入某个节点之前
     * @param index
     * @param t
     */
    public void add(int index, T t) {
        if (index == 0) {
            Node<T> node = new Node<T>(t,head,head.next);
            head.next.prev = node;
            head.next = node;
            count++;
            return;
        }

        Node<T> nextNode = getNode(index);
        Node<T> node = new Node<T>(t, nextNode.prev, nextNode);
        nextNode.prev.next = node;
        nextNode.prev = node;
        count++;
        return;
    }

    /**
     * 删除某一节点
     * @param index
     */
    public void deleteNode(int index) {
        Node<T> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        count--;
    }

    /**
     * 获取某位置节点值
     * @param index
     * @return
     */
    public T get(int index) {
        return getNode(index).value;
    }

    /**
     * 获取第一个节点的值
     * @return
     */
    public T getFirst() {
        return getNode(0).value;
    }

    /**
     * 获取最后一个节点的值
     * @return
     */
    public T getLast() {
        return getNode(count-1).value;
    }

    /**
     * 将节点插入首部
     * @param t
     */
    public void addFirst(T t) {
        add(0,t);
    }

    /**
     * 将节点追加到尾部
     * @param t
     */
    public void addLast(T t) {

        Node<T> node = new Node<T>(t, head.prev, head);
        head.prev.next = node;
        head.prev = node;
        count++;
    }

    /**
     * 删除第一个节点
     */
    public void deleteFirst() {
        deleteNode(0);
    }

    /**
     * 删除最后一个节点
     */
    public void deleteLast() {
        deleteNode(count-1);
    }

    /**
     * 返回链表长度
     * @return
     */
    public int length() {
        return count;
    }

    /**
     * 判断链表长度是否为空
     * @return
     */
    public boolean isEmpty() {
        return count==0;
    }

    /**
     * 遍历
     */
    public void print() {

        Node<T> node = head;
        for (int i = 0; i < count; i++) {
            System.out.print(node.next.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoubleLink<Integer> link = new DoubleLink<>();
        link.addLast(1);
        link.addLast(3);
        link.add(1,2);
        link.addFirst(0);
        link.print();
        System.out.println();
        System.out.println(link.getFirst());
        System.out.println(link.getLast());
        System.out.println(link.get(1));
        System.out.println(link.length());
        link.deleteFirst();
        link.print();
        System.out.println();
        link.deleteLast();
        link.print();
        System.out.println();
        link.deleteNode(1);
        link.print();
    }
}
