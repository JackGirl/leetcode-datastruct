package com.zbxx.datastructure;

import java.util.Arrays;
import java.util.logging.Logger;


/**
 * MyList 为空初始长度十
 *
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class MyList<E> {

    private static final Logger log = Logger.getLogger(MyList.class.getName());

    //数据数组
    private       Object[] data;
    //默认长度
    private final int      DEFAULT_SIZE = 10;
    //元素个数
    private       int      DATA_SIZE;

    public MyList() {
        data = new Object[DEFAULT_SIZE];
    }

    public MyList(int initCap) {
        if (initCap > 0) {
            data = new Object[initCap];
        } else if (initCap == 0) {
            data = new Object[]{};
        } else {
            throw new IllegalArgumentException("init size Exception!");
        }
    }


    /**
     * 检查数组长度 是否与当前元素个数相等
     *
     * @param size
     */
    private void checkLength(int size) {
        if (size - data.length > 0) {
            int newSize = size + (size >> 1);
            if (newSize - size < 0) {
                newSize = size;
            }
            if (newSize - Integer.MAX_VALUE > 0) {
                throw new OutOfMemoryError();
            }
            data = Arrays.copyOf(data, newSize);
        }
    }

    /**
     * 检测参数index是否超出数组元素个数
     *
     * @param index
     */
    private void rangeIndex(int index) {
        if (index >= DATA_SIZE || index < 0) {
            throw new IndexOutOfBoundsException("index exception is:" + index);
        }
    }

    /**
     * 当前一共有多少个元素
     *
     * @return
     */
    public int size() {
        return this.DATA_SIZE;
    }

    /**
     * 获取指定位置元素 下标从零开始
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeIndex(index);
        return (E) data[index];
    }

    /**
     * 添加 返回添加的元素
     *
     * @param e
     * @return
     */
    public E add(E e) {
        checkLength(DATA_SIZE + 1);
        data[DATA_SIZE++] = e;
        return e;
    }

    /**
     * 删除元素 将后面的元素往前移
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeIndex(index);
        E oldValue = (E) data[index];
        /**
         * 如果刚好是最后一个元素
         */
        if (index == DATA_SIZE - 1) {
            data[DATA_SIZE--] = null;
            return oldValue;
        }
        /**
         * 如果是第一个
         */
        if (index == 0) {
            Object newData[] = Arrays.copyOfRange(data, index + 1, data.length);
            data = newData;
            DATA_SIZE--;
            return oldValue;
        }
        this.changeDeleteData(index);
        DATA_SIZE--;
        return oldValue;
    }

    /**
     * 删除数组后元素位置变动
     */
    private void changeDeleteData(int index) {
        Object pre[] = Arrays.copyOfRange(data, 0, index);
        Object suf[] = Arrays.copyOfRange(data, index + 1, data.length);
        int newLength = pre.length + suf.length;
        Object[] newData = new Object[newLength];
        for (int i = 0; i < pre.length; i++) {
            newData[i] = pre[i];
        }
        for (int j = index; j < newData.length; j++) {
            newData[j] = suf[j - pre.length];
        }
        data = newData;
    }

    /**
     * 修改index 位置元素
     *
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        rangeIndex(index);
        E oldValue = (E) data[index];
        data[index] = e;
        return oldValue;
    }

    /**
     * 打印所有元素
     */
    public void printList() {
        for (int i = 0; i < DATA_SIZE; i++) {
            System.out.print(data[i] + " ");
        }
    }

}
