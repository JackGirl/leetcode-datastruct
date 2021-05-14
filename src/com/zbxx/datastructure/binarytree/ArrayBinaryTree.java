package com.zbxx.datastructure.binarytree;

public class ArrayBinaryTree {

    private ArrayTreeNode arrayTreeNode;

    public ArrayBinaryTree(int[] data) {
        arrayTreeNode = new ArrayTreeNode(data);
    }

    int frontSearch(int val) {
        if (!arrayTreeNode.isEmpty()) {
            return arrayTreeNode.frontSearch(0, val);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 43, 34, 3, 7, 9, 0};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        System.out.println(arrayBinaryTree.frontSearch(9));
    }
}
