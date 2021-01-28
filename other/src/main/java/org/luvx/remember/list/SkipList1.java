package org.luvx.remember.list;

import java.util.Objects;

/**
 * @ClassName: org.luvx
 * @Description: 有序链表 + 二分查找
 * <pre>
 *     不允许元素重复
 * </pre>
 * @Author: Ren, Xie
 */
public class SkipList1 {
    /**
     * 顶层头节点
     */
    private Node head;
    /**
     * 顶层尾节点
     */
    private Node tail;
    /**
     * 层次: 二分几次
     */
    private int  level;
    /**
     * 元素数量
     */
    private int  size;

    SkipList1() {
        this.level = 3;
    }

    SkipList1(int level) {
        this.level = level;
    }

    public boolean add(Integer data) {
        if (head == null) {
            Node node = new Node(data);
            head = node;
            return true;
        }
        Node node = findNode(data);
        if (Objects.equals(data, node.data)) {
            return true;
        } else if (Objects.equals(node.data, head.data)) {
            Node temp = head, up = null;
            while (temp != null) {
                Node node1 = new Node(data, temp);
                if (up == null) {
                    up = node1;
                    head = node1;
                } else {
                    up.down = node1;
                }
                temp = temp.next;
            }
        } else {
            Node node1 = new Node(data, node.next);
            node.next = node1;
        }

        // 层级维护
        return true;
    }

    public boolean remove(Integer n) {
        return false;
    }

    public Node get(Integer data) {
        Node n = findNode(data);
        return Objects.equals(data, n.data) ? n : null;
    }

    private Node findNode(Integer data) {
        Node pre = head;
        while (true) {
            Node temp = pre;
            while (temp != null && temp.data < data) {
                if (Objects.equals(data, temp.data)) {
                    return temp;
                }
                if (temp.next != null && data < temp.next.data) {
                    break;
                }
                temp = temp.next;
            }

            if (temp.down != null) {
                pre = temp.down;
            } else {
                break;
            }
        }
        return pre;
    }

    public int getLevel() {
        return level;
    }

    private class Node {
        public Integer data;
        public Node    next;
        public Node    down;

        Node(Integer data) {
            this.data = data;
        }

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
