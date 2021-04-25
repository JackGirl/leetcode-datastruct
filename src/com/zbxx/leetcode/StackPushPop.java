package src.com.zbxx.leetcode;


import java.util.Stack;

/**
 * 给定一组数字从小到大入栈  打印所有合法出栈序列
 */
public class StackPushPop {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stack stack = new Stack();
        Stack queue = new Stack();
        pushPop(stack, queue, arr, 0);
    }

    public static void pushPop(Stack stack, Stack queue, int[] arr, int index) {
        //元素已经全部操作完了
        if (index == arr.length) {
            queue.forEach(System.out::print);
            for (int i = stack.size() - 1; i >= 0; i--) {
                System.out.print(stack.elementAt(i));
            }
            System.out.println();
            return;
        }
        if (!stack.isEmpty()) {
            //出栈
            Object o = stack.pop();
            queue.add(o);
            pushPop(stack, queue, arr, index);
            //把刚刚出栈的元素放回 操作上一次的入栈
            stack.push(queue.pop());
        }
        stack.push(arr[index]);
        pushPop(stack, queue, arr, index + 1);
        stack.pop();


    }


}
