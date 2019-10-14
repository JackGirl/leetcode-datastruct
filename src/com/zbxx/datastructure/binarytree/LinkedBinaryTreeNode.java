package src.com.zbxx.datastructure.binarytree;

/**
 * @author :    万仁杰
 * @description : 二叉树
 * @createDate : 16:14 2019/10/7
 * @modifyDate :
 */
public class LinkedBinaryTreeNode {

	private LinkedBinaryTreeNode left;

	private Object value;

	private LinkedBinaryTreeNode right;


	public LinkedBinaryTreeNode(Object value) {
		this.value = value;
	}

	public LinkedBinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(LinkedBinaryTreeNode left) {
		this.left = left;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public LinkedBinaryTreeNode getRight() {
		return right;
	}

	public void setRight(LinkedBinaryTreeNode right) {
		this.right = right;
	}

	public static void frontEach(LinkedBinaryTreeNode node) {
		System.out.println(node.getValue());
		if (node.getLeft() != null) {
			frontEach(node.getLeft());
		}
		if (node.getRight() != null) {
			frontEach(node.getRight());
		}
	}


	public static void midEach(LinkedBinaryTreeNode node) {
		if (node.getLeft() != null) {
			midEach(node.getLeft());
		}
		System.out.println(node.getValue());
		if (node.getRight() != null) {
			midEach(node.getRight());
		}
	}

	public static void afterEach(LinkedBinaryTreeNode node) {
		if (node.getLeft() != null) {
			afterEach(node.getLeft());
		}
		if (node.getRight() != null) {
			afterEach(node.getRight());
		}
		System.out.println(node.getValue());
	}
}
