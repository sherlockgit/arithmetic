package linear;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * Description: 栈结构（基于数组实现）
 * User: sherlock
 * Date: 2018-07-23
 */
public class Stack<T> {

    /**
     * 存放数据的数组
     */
    private T[] array;

    /**
     * 栈长度
     */
    private int count;

    /**
     * 构造函数
     * @param clazz
     * @param size
     */
    public Stack(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
        count = 0;
    }

    /**
     * 往栈顶存值
     * @param value
     */
    public void push(T value) {
        array[count++] = value;
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public T pop() {
        return array[count-1];
    }

    /**
     * 返回栈顶元素并将其删除
     * @return
     */
    public T peek() {
        T ret = array[count-1];
        count--;
        return ret;
    }

    /**
     * 返回栈的大小
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * 打印栈
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Empty");
        }

        int i = size() - 1;
        while (i >= 0) {
            System.out.println(array[i]);
            i--;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(Integer.class,8);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.print();
        System.out.println("取出栈顶元素："+stack.pop());
        System.out.println("取出栈顶元素并删除："+stack.peek());
        stack.print();
    }
}
