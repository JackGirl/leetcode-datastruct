package com.zbxx.leetcode.book.bst;


import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode book bst 最近公共祖先
 */
public class bst_lowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }


  /*  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> n1 = new LinkedList<>();
        LinkedList<TreeNode> n2 = new LinkedList<>();
        dfs(root,p,n1);
        dfs(root,q,n2);
        Iterator<TreeNode> l = n1.iterator();
        Iterator<TreeNode> r = n2.iterator();
        TreeNode pre = null;
        while (l.hasNext()&&r.hasNext()){
            TreeNode ln = l.next();
            if(ln==r.next()){
                pre = ln;
            }
            if(ln==p||ln==q){
                break;
            }
        }
        return pre;
    }

    private void dfs(TreeNode root, TreeNode p, LinkedList<TreeNode> n1) {
        n1.add(root);
        if(root == p){
            return;
        }
        int cmp = p.val-root.val;
        if(cmp>0){
            dfs(root.right,p,n1);
        }else{
            dfs(root.left,p,n1);
        }
    }*/


}
