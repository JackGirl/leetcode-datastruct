package com.zbxx.datastructure;

import lombok.AllArgsConstructor;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


/**
 * 2-3-4 红黑树
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K extends Comparable, V> {


    @AllArgsConstructor
    static class TreeNode<K extends Comparable, V> {

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


        public TreeNode<K, V> getRoot() {
            TreeNode<K, V> p = this;
            while (p.parent != null) {
                p = p.parent;
            }
            return p;
        }

        @Override
        public int hashCode() {
            return hash(k) & hash(v);
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

    final boolean RED = Boolean.TRUE;

    final boolean BLACK = Boolean.FALSE;


    TreeNode<K, V>[] table;

    Set<K> keys = new HashSet<>();

    final static Integer DEFAULT_CAPACITY = 16;

    int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int initCapacity) {
        int capacity = initCapacity <= 0 ? DEFAULT_CAPACITY : initCapacity;
        table = new TreeNode[initCapacity];
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public TreeNode<K, V> find(TreeNode<K, V> node, K k) {
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


    private void resize() {

    }

    public boolean containsKey(K k) {
        return get(k) != null;
    }

    public V put(K k, V v) {
        return putVal(hash(k), k, v);
    }

    private int index(int hash, int length) {
        return hash & (table.length - 1);
    }

    public V putVal(int hash, K k, V v) {
        TreeNode<K, V> root = table[index(hash, table.length)];
        return put(hash, root, k, v);
    }

    public V put(int hash, TreeNode<K, V> node, K k, V v) {
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
            keys.add(k);
            size++;
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
        table[index(hash, table.length)] = n.getRoot();
        return value;
    }

    /**
     * 重新着色
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


    public V get(K k) {
        int hash = hash(k);
        TreeNode<K, V> root = table[index(hash, table.length)];
        if (root == null) {
            return null;
        }
        TreeNode<K, V> p = find(root, k);
        return p != null ? p.getValue() : null;
    }


    public V remove(K k) {
        int hash = hash(k);
        TreeNode<K, V> root = table[index(hash, table.length)];
        if (root == null) {
            return null;
        }
        TreeNode<K, V> node = del(find(root, k));
        return node == null ? null : node.getValue();
    }

    private TreeNode<K, V> getBrother(TreeNode<K, V> node) {
        if (node.parent == null) {
            return null;
        }
        return node.equals(node.parent.left) ? node.parent.right : node.parent.left;
    }

    private TreeNode<K, V> del(TreeNode<K, V> node) {
        //没有子节点
        if (node.left == null && node.right == null) {
            if (node.isRed()) {
                TreeNode<K, V> p = node.parent;
                boolean nLeft = node.equals(p.left) ? true : false;
                TreeNode<K, V> brother = getBrother(node);
                //当前节点在左边
                if (nLeft) {
                    //兄弟节点右边黑色
                    if (!brother.isRed()) {
                        if (brother.left != null || brother.right != null) {
                            //右节点
                            if (brother.left == null) {
                                p.left = null;
                                brother.right.setColor(BLACK);
                                brother.setColor(p.red);
                                p.setColor(BLACK);
                                rotateLeft(p);
                                return node;
                                //兄弟节点左节点
                            } else if (brother.right == null) {
                                TreeNode<K, V> newBrother = rotateRight(brother);
                                newBrother.setColor(p.red);
                                p.setColor(BLACK);
                                newBrother.right.setColor(BLACK);
                            } else {
                                p.left = null;
                                p.setColor(BLACK);
                                brother.right.setColor(BLACK);
                                rotateLeft(p);
                            }
                        }
                    }

                } else {

                }

            } else {

            }
        }
        //单个子节点  交换  删除
        else if (node.left == null || node.right == null) {
            if (node.left == null) {

            } else {

            }
        } else {
            //左右不为空 从右子树找后继节点交换删除
        }
        return node;
    }


    /**
     * 当前节点黑色没有子节点  一定右兄弟节点 否则不满足黑平衡
     *
     * @param node
     */
    private TreeNode<K, V> recolorOnDel(TreeNode<K, V> node) {
        TreeNode<K, V> brother = getBrother(node);
        if (node.isRoot()) {
            return node;
        }
        TreeNode<K, V> parent = node.parent;
        if (!brother.isRed()) {
            if (brother.left == null && brother.right != null) {
                brother.right.setColor(BLACK);
                brother.setColor(parent.red);
                parent.setColor(BLACK);

            }
        } else {

        }
        return null;
    }


    private TreeNode<K, V> rotateLeft(TreeNode<K, V> node) {

        TreeNode<K, V> t = node.right;
        TreeNode<K, V> gp = node.parent;
        node.right = t.left;
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

    private TreeNode<K, V> rotateRight(TreeNode<K, V> node) {
        TreeNode<K, V> t = node.left;
        TreeNode<K, V> gp = node.parent;
        node.left = t.right;
        node.parent = t;
        t.right = node;
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


    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    Iterable<K> keys() {
        return keys;
    }


    public static void main(String[] args) {
        MyHashMap h = new MyHashMap();
        h.putVal(3333, 30, "30");
        h.putVal(3333, 17, "17");
        h.putVal(3333, 29, "29");
        h.putVal(3333, 77, "77");
        h.putVal(3333, 93, "93");
        h.putVal(3333, 16, "16");
        h.putVal(3333, 13, "13");
        h.putVal(3333, 36, "36");
        h.putVal(3333, 73, "73");
        TreeNode treeNode = h.table[5];
        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(treeNode);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            System.out.println("val:" + node.getValue() + " red:" + node.isRed());
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }

    }

}
