package src.com.zbxx.datastructure;


import src.com.zbxx.util.ArrayUtils;

import java.util.Arrays;

/**
 * 大顶堆
 *
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {

    T[] elements;

    private int size;

    public Heap(int initialSize) {
        this.elements = (T[]) new Comparable[initialSize];
    }


    /**
     * 插入后上浮
     *
     * @param element
     */
    public void insert(T element) {
        elements[size++] = element;
        if (size == 1) {
            return;
        }
        bubble(size - 1);
    }

    private void bubble(int index) {
        if (index == 0) {
            return;
        }
        int pIndex = (index - 1) / 2;
        while (pIndex >= 0 && elements[pIndex].compareTo(elements[index]) < 0) {
            ArrayUtils.swap(elements, pIndex, index);
            index = pIndex;
            pIndex = (index - 1) / 2;
        }
    }


    /**
     * 删除堆顶元素
     *
     * @return
     */
    public Comparable<T> deleteMax() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return removeMax();
        }
        ArrayUtils.swap(elements, 0, size - 1);
        Comparable<T> comparable = removeMax();
        sin(0);
        return comparable;
    }

    /**
     * 将某位置元素下移
     *
     * @param index
     */
    public void sin(int index) {
        while (2 * index + 1 < size) {
            if (2 * index + 2 < size) {
                if (elements[2 * index + 2].compareTo(elements[2 * index + 1]) >= 0) {
                    ArrayUtils.swap(elements, index, 2 * index + 2);
                    index = 2 * index + 2;
                } else {
                    ArrayUtils.swap(elements, index, 2 * index + 1);
                    index = 2 * index + 1;
                }
            } else {
                if (elements[index].compareTo(elements[2 * index + 1]) < 0) {
                    ArrayUtils.swap(elements, index, 2 * index + 1);
                }
                index = 2 * index + 1;
            }
        }
    }


    public Comparable<T> removeMax() {
        Comparable<T> element = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return element;
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(12);
        heap.insert(1);
        heap.insert(2);
        heap.insert(7);
        heap.insert(4);
        heap.insert(6);
        heap.insert(9);
        heap.insert(8);
        heap.insert(11);
        System.out.println(Arrays.toString(heap.elements));
        heap.deleteMax();
        System.out.println(Arrays.toString(heap.elements));
        Comparable comparable = null;
        while ((comparable = heap.deleteMax()) != null) {
            System.out.println(comparable);
        }

    }


}
