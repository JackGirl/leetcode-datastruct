package com.zbxx.datastructure.binarytree;


/**
 * @author :    万仁杰
 * @description : 顺序二叉树
 * <remark>
 * 只考虑完全二叉树   左节点2N+1 右节点2N+2
 * </remark>
 * @createDate : 9:34 2019/10/10
 * @modifyDate :
 */
public class ArrayTreeNode {

    private int[] data;

    public ArrayTreeNode(int[] array) {
        this.data = array;
    }

    /**
     * @description : 检查data为空 用包装类
     * @author :    万仁杰
     * @createDate : 11:21 2019/10/10
     * @modifyDate :
     */
    public int frontSearch(int index, int value) {
        int searchIndex = -1;
        if (index < data.length) {
            if (data[index] == value) {
                return index;
            }
            if (index <= data.length) {
                searchIndex = frontSearch(2 * index + 1, value);
            }
            if (searchIndex == -1) {
                if (index <= data.length) {
                    searchIndex = frontSearch(2 * index + 2, value);
                }
            }
        }


        return searchIndex;
    }

    public boolean isEmpty() {
        return data == null || data.length == 0;
    }
}
