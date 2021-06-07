package com.zbxx.datastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 红黑树  2-3-4类型
 *
 * @author 76594
 */
@Getter
public class RedBlackBalancedTree<K extends Comparable<K>, V> {

    final boolean RED = Boolean.TRUE;

    final boolean BLACK = Boolean.FALSE;

    TreeNode<K, V> root;

    @AllArgsConstructor
    static class TreeNode<K extends Comparable<K>, V> {

        K k;

        V v;

        boolean red;

        TreeNode<K, V> parent;

        TreeNode<K, V> left;

        TreeNode<K, V> right;

        public void setColor(boolean red) {
            this.red = red;
        }

        public V getValue() {
            return v;
        }

        public V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }

        public boolean isRoot() {
            return parent == null;
        }

        public boolean isRed() {
            return red;
        }

        public void setK(K k) {
            this.k = k;
        }

        public K getKey() {
            return k;
        }

        /**
         * 获取兄弟节点
         *
         * @return
         */
        private TreeNode<K, V> getBrother() {
            if (this.parent == null) {
                return null;
            }
            return this.equals(this.parent.left) ? this.parent.right : this.parent.left;
        }


        /**
         * 获取根节点
         *
         * @return
         */
        public TreeNode<K, V> getRoot() {
            TreeNode<K, V> p = this;
            while (p.parent != null) {
                p = p.parent;
            }
            return p;
        }

        /**
         * 右子树后继节点
         *
         * @return
         */
        public TreeNode<K, V> findRightMin() {
            if (this.right == null) {
                return null;
            }
            TreeNode<K, V> node = this.right;
            while (node != null) {
                if (node.left == null) {
                    break;
                }
                node = node.left;
            }
            return node;
        }


        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof TreeNode && this.hashCode() == obj.hashCode()) {
                TreeNode node = (TreeNode) obj;
                return this.k.equals(node.getKey()) && this.getValue().equals(node.getKey());
            }
            return false;
        }
    }


    /**
     * 插入的重新着色和旋转
     *
     * @param node
     */
    private void recolorAndRotate(TreeNode<K, V> node) {
        if (node.isRoot()) {
            node.setColor(BLACK);
            return;
        }
        if (node.parent == null || !node.parent.isRed()) {
            return;
        }
        TreeNode<K, V> grandP = node.parent.parent;
        TreeNode<K, V> parent = node.parent;
        //父节点红  uncle节点红
        if (node.parent.isRed()) {
            TreeNode<K, V> uncle = parent.equals(grandP.left) ? grandP.right : grandP.left;
            boolean uncleRed = uncle == null ? false : uncle.isRed();
            //uncle节点红色
            if (uncleRed) {
                parent.setColor(BLACK);
                uncle.setColor(BLACK);
                grandP.setColor(RED);
                recolorAndRotate(grandP);
            } else {
                //parent节点红色  uncle节点黑色
                boolean pLeft = parent.equals(grandP.left) ? true : false;
                boolean selfLeft = node.equals(parent.left) ? true : false;
                //都在左边
                if (pLeft && selfLeft) {
                    //grandp节点右旋
                    rotateRight(grandP);
                    grandP.setColor(RED);
                    parent.setColor(BLACK);
                } else if (!pLeft && !selfLeft) {
                    // parent 节点和当前节点都在右边  grandp左旋
                    rotateLeft(grandP);
                    grandP.setColor(RED);
                    parent.setColor(BLACK);
                } else if (pLeft) {
                    //parent 左节点  当前节点右节点
                    TreeNode<K, V> t = rotateLeft(parent);
                    recolorAndRotate(t.left);
                } else if (selfLeft) {
                    //当前节点左边 父节点右边
                    TreeNode<K, V> t = rotateRight(parent);
                    recolorAndRotate(t.right);
                }
            }
        }
    }

    /**
     * 左旋
     *
     * @param node
     * @return
     */
    private TreeNode<K, V> rotateLeft(TreeNode<K, V> node) {

        TreeNode<K, V> t = node.right;
        TreeNode<K, V> gp = node.parent;
        node.right = t.left;
        if (t.left != null) {
            t.left.parent = node;
        }
        node.parent = t;
        t.left = node;
        t.parent = gp;
        if (gp != null) {
            boolean left = node.equals(gp.left) ? true : false;
            if (left) {
                gp.left = t;
            } else {
                gp.right = t;
            }
        }
        return t;
    }


    /**
     * 右旋
     *
     * @param node
     * @return
     */
    private TreeNode<K, V> rotateRight(TreeNode<K, V> node) {
        TreeNode<K, V> t = node.left;
        TreeNode<K, V> gp = node.parent;
        node.left = t.right;
        if (t.right != null) {
            t.right.parent = node;
        }
        t.right = node;
        node.parent = t;
        t.parent = gp;
        if (gp != null) {
            boolean left = node.equals(gp.left) ? true : false;
            if (left) {
                gp.left = t;
            } else {
                gp.right = t;
            }
        }
        return t;
    }

    public V get(K k) {
        TreeNode<K, V> node = find(root, k);
        return node == null ? null : node.getValue();
    }

    private TreeNode<K, V> find(TreeNode<K, V> node, K k) {
        if (node == null) {
            return null;
        }
        int cmp = node.getKey().compareTo(k);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return find(node.left, k);
        } else {
            return find(node.right, k);
        }
    }


    public V put(K k, V v) {
        return put(root, k, v);
    }

    private V put(TreeNode<K, V> node, K k, V v) {
        TreeNode<K, V> p = node;
        TreeNode<K, V> n = node;
        boolean find = false;
        boolean left = false;
        while (n != null) {
            int cmp = n.getKey().compareTo(k);
            if (cmp == 0) {
                p = n.parent;
                find = true;
            } else if (cmp > 0) {
                p = n;
                n = p.left;
                left = true;
            } else {
                p = n;
                n = p.right;
                left = false;
            }
        }
        if (n == null) {
            n = new TreeNode<>(k, v, RED, p, null, null);
        }
        if (!find && p != null) {
            if (left) {
                p.left = n;
            } else {
                p.right = n;
            }
        }
        V value = n.setValue(v);
        recolorAndRotate(n);
        root = n.getRoot();
        return value;
    }

    public V remove(K k) {
        TreeNode<K, V> node = find(root, k);
        if (node == null) {
            return null;
        }
        TreeNode<K, V> t = remove(node);
        return t.getValue();
    }


    public TreeNode<K, V> remove(TreeNode<K, V> node) {
        if (node.left == null || node.right == null) {
            if (node.left == null && node.right == null) {
                TreeNode<K, V> parent = node.parent;
                rotateOnDel(node);
                if (!node.isRoot()) {
                    if (node.equals(parent.left)) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    root = node.getRoot();
                    root.setColor(BLACK);
                    node.parent = null;
                } else {
                    root = null;
                }
                return node;
            } else if (node.right == null) {
                swapNodeKeyValue(node, node.left);
                return remove(node.left);
            } else {
                swapNodeKeyValue(node, node.right);
                return remove(node.right);
            }
        } else {
            //左右不为空 从右子树找后继节点交换删除
            TreeNode<K, V> rightMin = node.findRightMin();
            swapNodeKeyValue(node, rightMin);
            return remove(rightMin);
        }
    }

    public void swapNodeKeyValue(TreeNode<K, V> t1, TreeNode<K, V> t2) {
        if (t1 == null || t2 == null) {
            return;
        }
        TreeNode<K, V> temp = new TreeNode<>(t1.getKey(), t1.getValue(), RED, null, null, null);
        t1.setK(t2.getKey());
        t1.setValue(t2.getValue());
        t2.setValue(temp.getValue());
        t2.setK(temp.getKey());
    }

    /**
     * 删除前调整
     *
     * @param node
     */
    public void rotateOnDel(TreeNode<K, V> node) {
        //红色叶子节点 直接删除就行
        if (node.isRed() || node.isRoot()) {
            return;
        }

        //黑色节点一定有兄弟节点
        TreeNode<K, V> brother = node.getBrother();
        TreeNode<K, V> parent = node.parent;
        boolean nleft = node.equals(node.parent.left) ? true : false;

        if (nleft) {
            if (brother.isRed()) {
                parent.setColor(RED);
                brother.setColor(BLACK);
                rotateLeft(parent);
                rotateOnDel(node);
            } else {
                //兄弟节点黑色 且有子节点
                if (brother.left != null || brother.right != null) {
                    //一个右节点
                    if (brother.left == null) {
                        brother.right.setColor(BLACK);
                        brother.setColor(parent.red);
                        parent.setColor(BLACK);
                        rotateLeft(parent);
                    } else if (brother.right == null) {
                        //一个左节点
                        brother.left.setColor(parent.red);
                        rotateRight(brother);
                        parent.setColor(BLACK);
                        rotateLeft(parent);
                    } else {
                        //两个子节点
                        brother.right.setColor(BLACK);
                        brother.setColor(parent.red);
                        parent.setColor(BLACK);
                        rotateLeft(parent);
                    }
                } else {
                    //黑色兄弟 没有子节点
                    brother.setColor(RED);
                    if (parent.isRed()) {
                        parent.setColor(BLACK);
                    } else {
                        rotateOnDel(parent);
                    }
                }
            }
        }
        //当前节点右边
        else {

            if (brother.isRed()) {
                parent.setColor(RED);
                brother.setColor(BLACK);
                rotateRight(parent);
                rotateOnDel(node);
            } else {
                //兄弟节点黑色 且有子节点
                if (brother.left != null || brother.right != null) {
                    //一个右节点
                    if (brother.left == null) {
                        brother.right.setColor(parent.red);
                        rotateLeft(brother);
                        parent.setColor(BLACK);
                        rotateRight(parent);
                    } else if (brother.right == null) {
                        //一个左节点
                        brother.left.setColor(BLACK);
                        brother.setColor(parent.red);
                        parent.setColor(BLACK);
                        rotateRight(parent);
                    } else {
                        //两个子节点
                        brother.setColor(parent.red);
                        brother.left.setColor(BLACK);
                        parent.setColor(BLACK);
                        rotateRight(parent);
                    }
                } else {
                    //黑色兄弟 没有子节点
                    brother.setColor(RED);
                    if (parent.isRed()) {
                        parent.setColor(BLACK);
                    } else {
                        rotateOnDel(parent);
                    }
                }
            }

        }


    }


    public static void main(String[] args) {
        RedBlackBalancedTree<Integer, String> redBlackBalancedTree = new RedBlackBalancedTree<>();
        redBlackBalancedTree.put(30, "30");
        redBlackBalancedTree.put(17, "17");
        redBlackBalancedTree.put(29, "29");
        redBlackBalancedTree.put(77, "77");
        redBlackBalancedTree.put(93, "93");
        redBlackBalancedTree.put(16, "16");
        redBlackBalancedTree.put(13, "13");
        redBlackBalancedTree.put(36, "36");
        redBlackBalancedTree.put(73, "73");

      /*  Deque<TreeNode> deque = new LinkedList();
        deque.addLast(redBlackBalancedTree.getRoot());
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            System.out.println("val:" + node.getValue() + " red:" + node.isRed());
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }*/


        System.out.println(redBlackBalancedTree.get(30));
    /*    redBlackBalancedTree.remove(93);
        redBlackBalancedTree.remove(30);
        redBlackBalancedTree.remove(36);
        redBlackBalancedTree.remove(29);
        redBlackBalancedTree.remove(73);
        redBlackBalancedTree.remove(16);
        redBlackBalancedTree.remove(77);
        redBlackBalancedTree.remove(13);
        redBlackBalancedTree.remove(17);

        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(redBlackBalancedTree.getRoot());
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            System.out.println("val:" + node.getValue() + " red:" + node.isRed());
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }*/
    }

}
