package com.zbxx.datastructure;

public class MyStack {

    private Object[] elements;

    public MyStack() {
        elements = new Object[0];
    }

    public Object pop() {
        Object[] newElements = new Object[elements.length - 1];
        for (int i = 0; i < elements.length - 1; i++) {
            newElements[i] = elements[i];
        }
        Object val = elements[elements.length - 1];
        elements = newElements;
        return val;
    }

    public Object push(Object element) {
        Object[] newElements = new Object[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        newElements[elements.length] = element;
        elements = newElements;
        return element;
    }


    public Object seek() {
        return elements[elements.length - 1];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(5);
        System.out.println(stack.seek());
        for (int i = 0; i < stack.elements.length; i++) {
            System.out.print(stack.elements[i] + " ");
        }
        stack.pop();
        System.out.println(stack.seek());
        for (int i = 0; i < stack.elements.length; i++) {
            System.out.print(stack.elements[i] + " ");
        }
    }


}
