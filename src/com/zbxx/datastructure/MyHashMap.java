package com.zbxx.datastructure;

import lombok.AllArgsConstructor;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * hashMao 红黑树
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

        public TreeNode<K, V> find(K k) {
            if (this.k == k) {
                return this;
            }
            TreeNode<K, V> p = this;
            do {
                int cmp = this.k.compareTo(k);
                if (cmp == 0) {
                    return this;
                }
                if (cmp > 0) {
                    p = p.left;
                }
                if (cmp < 0) {
                    p = p.right;
                }
            } while (p != null);
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
    /**
     * 数据
     */
    TreeNode<K, V>[] table;
    /**
     * 默认大小
     */
    final static Integer DEFAULT_CAPACITY = 16;
    /**
     * elementSize
     */
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
            size++;
        }
        if (!find && p != null) {
            if (left) {
                p.left = n;
            } else {
                p.right = n;
            }
        }
        n.parent = p;
        V value = n.setValue(v);
        recolorAndRotate(n);
        table[index(hash, table.length)] = n.getRoot();
        return value;
    }

    /**
     * 空连接默认是黑的
     *
     * @param node table[index(hash,table.length)] = node.getRoot();
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
                recolorAndRotate(grandP);
            } else {
                //parent节点红色  uncle节点黑色
                boolean pLeft = parent.equals(grandP.left) ? true : false;
                boolean selfLeft = node.equals(parent.left) ? true : false;
                //都在左边
                if (pLeft && selfLeft) {
                    //grandp节点右旋
                    if (grandP.parent != null) {
                        boolean gpLeft = grandP.equals(grandP.parent.left) ? true : false;
                        if (gpLeft) {
                            grandP.parent.left = parent;
                        } else {
                            grandP.parent.right = parent;
                        }
                    }
                    parent.parent = grandP.parent;
                    grandP.left = parent.right;
                    parent.right = grandP;
                    grandP.parent = parent;
                    grandP.setColor(RED);
                    parent.setColor(BLACK);
                } else if (!pLeft && !selfLeft) {
                    // parent 节点和当前节点都在右边  grandp左旋
                    if (grandP.parent != null) {
                        boolean gpLeft = grandP.equals(grandP.parent.left) ? true : false;
                        if (gpLeft) {
                            grandP.parent.left = parent;
                        } else {
                            grandP.parent.right = parent;
                        }
                    }
                    parent.parent = grandP.parent;
                    grandP.parent = parent;
                    grandP.right = parent.left;
                    parent.left = grandP;
                    grandP.setColor(RED);
                    parent.setColor(BLACK);
                } else if (pLeft) {
                    //parent 左节点  当前节点右节点
                    node.parent = parent.parent;
                    parent.right = node.left;
                    parent.parent = node;
                    grandP.left = node;
                    node.left = parent;
                    recolorAndRotate(parent);
                } else if (selfLeft) {
                    //当前节点左边 父节点右边
                    node.parent = parent.parent;
                    parent.left = node.right;
                    parent.parent = node;
                    grandP.right = node;
                    node.right = parent;
                    recolorAndRotate(parent);
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
        TreeNode<K, V> p = root.find(k);
        return p != null ? p.getValue() : null;
    }

    public boolean remove(K k) {
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    Iterable<K> keys() {
        return null;
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
        System.out.println(h);
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
