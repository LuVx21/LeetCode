package org.luvx.remember.list;

/**
 * @ClassName: org.luvx
 * @Description: 有序连接 + 二分查找
 * <pre>
 *     允许元素重复
 * </pre>
 * @Author: Ren, Xie
 */
public class SkipList<T> {
    private Node head;
    private Node tail;
    /**
     * 层次: 二分几次
     */
    private int  level;
    /**
     * 元素数量
     */
    private int  size;

    SkipList() {
        this.level = 3;
    }

    SkipList(int level) {
        this.level = level;
    }

    public boolean add(T n) {
        if (head == null) {
            Node<T> node = new Node<>(n);
            node.next = new Node[level];
            head = node;
        }
        return false;
    }

    public boolean remove(T n) {
        return false;
    }

    public Node get(T data) {
        return null;
    }

    public int getLevel() {
        return level;
    }

    private class Node<T> {
        public T      data;
        public Node[] next;

        Node() {
        }

        Node(T data) {
            this.data = data;
        }
    }
}
