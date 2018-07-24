package linear;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * Description: 队列结构（基于数组实现）
 * User: sherlock
 * Date: 2018-07-24
 */
public class Queue<T> {

    /**
     * 存放数据的数组
     */
    private T[] array;

    /**
     * 队列长度
     */
    private int count;

    /**
     * 构造函数
     * @param clazz
     * @param size
     */
    public Queue(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
        count = 0;
    }

    /**
     * 将值添加到队列尾
     * @param value
     */
    public void add(T value) {
        array[count++] = value;
    }

    /**
     * 返回开头值
     * @return
     */
    public T pop() {
        return array[0];
    }

    /**
     * 返回队列值并删除
     * @return
     */
    public T peek() {
        T value = array[0];
        count--;

        /*队列重构*/
        for (int i = 1; i <= count; i++) {
            array[i-1] = array[i];
        }
        return value;
    }

    /**
     * 返回队列值并将其删除
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(Integer.class,8);

        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.print();
        System.out.println("取出队列头元素："+queue.pop());
        System.out.println("取出队列头元素并删除："+queue.peek());
        queue.print();
    }
}
