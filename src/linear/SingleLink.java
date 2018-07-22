package linear;

/**
 * Created with IntelliJ IDEA.
 * Description: 单向链表结构
 * User: sherlock
 * Date: 2018-07-22
 */
public class SingleLink<T> {

    /**
     * 表头
     */
    private Node<T> head;

    /**
     * 节点个数
     */
    private int count;

    /**
     * 单向链表对应的结构体
     * @param <T>
     */
    private class Node<T> {

        public Node next;
        public T value;

        public Node(T value, Node next) {
            this.next = next;
            this.value = value;
        }

    }

    /**
     * 构造函数
     */
    public SingleLink() {

        /*初始化链表结构*/
        head = new Node<>(null,null);
        head.next = head;

        /*初始化节点个数*/
        count = 0;
    }

    /**
     * 返回链表长度
     * @return
     */
    public int length() {
        return count;
    }

    /**
     * 判断该链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 获取某位置的节点
     * @param index
     * @return
     */
    private Node<T> getNode(int index) {

        /*当index小于0或者越界时抛出异常*/
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        /*遍历节点并得出某下标的节点，时间复杂度O(n)*/
        Node<T> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    /**
     * 将节点插入到某个节点之前
     * @param index
     * @param t
     */
    public void add(int index, T t) {

        /*插入首部*/
        if (index == 0) {
            Node<T> node = new Node<T>(t, head.next);
            head.next = node;
            count++;
            return;
        }

        /*插入某个位置*/
        Node<T> indexNode = getNode(index);
        Node<T> prevNode = getNode(index-1);
        Node<T> node = new Node<T>(t,indexNode);
        prevNode.next = node;
        count++;
        return;
    }

    /**
     * 删除某一位置的节点
     * @param index
     */
    public void deleteNode(int index) {

        /*删除第一个节点*/
        if (index == 0) {
            head.next = getNode(index+1);
            count--;
        }

        Node<T> node = getNode(index);
        Node<T> prevNode = getNode(index-1);
        prevNode.next = node.next;
        count--;
        return;
    }

    /**
     * 删除第一个节点
     */
    public void deleteFrist() {
        deleteNode(0);
    }

    /**
     * 删除最后一个节点
     */
    public void deleteLast() {
        Node<T> node = getNode(count-2);
        node.next = head;
        count--;
    }

    /**
     * 将节点插入首部
     * @param t
     */
    public void addFrist(T t) {
        add(0,t);
    }

    /**
     * 将节点追加到末尾
     * @param t
     */
    public void addLast(T t) {

        /*判断是否为首次添加*/
        if (count == 0) {
            Node<T> node = new Node<>(t,head);
            head.next = node;
            count++;
            return;
        }

        Node<T> lastNode = getNode(count-1);
        Node<T> node = new Node<>(t,head);
        lastNode.next = node;
        count++;
        return;
    }

    /**
     * 获取某位置节点的值
     * @param index
     * @return
     */
    public T get(int index) {
        return getNode(index).value;
    }

    /**
     * 获取第一个位置节点的值
     * @return
     */
    public T getFirst() {
        return getNode(0).value;
    }

    /**
     * 获取最后一个位置节点的值
     * @return
     */
    public T getLast() {
        return getNode(count-1).value;
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

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        SingleLink<Integer> link = new SingleLink<>();
        link.addLast(1);
        link.addLast(2);
        link.print();
        System.out.println(link.getFirst());
    }
}
