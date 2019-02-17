package src.test;

import src.datastructure.MyLinkedList;

public class TestLink {


    public static void main(String[] args) {
        MyLinkedList<String> test = new MyLinkedList<>();
        test.add("a");
        test.add("b");
        test.add("c");
        System.out.println(test.size());
        test.remove(2);
        System.out.println(test.size());
        test.printElem();
    }

}
