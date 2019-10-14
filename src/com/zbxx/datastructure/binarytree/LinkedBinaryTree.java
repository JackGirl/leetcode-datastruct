package src.com.zbxx.datastructure.binarytree;

public class LinkedBinaryTree {

	private LinkedBinaryTreeNode root;


	public LinkedBinaryTree(LinkedBinaryTreeNode root) {
		this.root = root;
	}

	public void frontEach() {
		LinkedBinaryTreeNode.frontEach(root);
	}

	public void midEach() {
		LinkedBinaryTreeNode.midEach(root);
	}

	public void afterEach() {
		LinkedBinaryTreeNode.afterEach(root);
	}


	public static void main(String[] args) {
		LinkedBinaryTreeNode root = new LinkedBinaryTreeNode(1);
		LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree(root);
		LinkedBinaryTreeNode left = new LinkedBinaryTreeNode(2);
		left.setLeft(new LinkedBinaryTreeNode(3));
		left.setRight(new LinkedBinaryTreeNode(3));
		root.setLeft(left);
		root.setRight(new LinkedBinaryTreeNode(6));
		linkedBinaryTree.frontEach();
		System.out.println("==============");
		linkedBinaryTree.midEach();
		System.out.println("==============");
		linkedBinaryTree.afterEach();
	}
}
