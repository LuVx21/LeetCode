package org.luvx.remember.lru;

import java.util.Hashtable;

/**
 * @author Ren, Xie
 */
public class LRUCache {
    private int count;

    private final Hashtable<Integer, Node> cache = new Hashtable<>();

    private final int  capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node pre = node.pre, next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private Node popTail() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            count++;
            if (count > capacity) {
                Node tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    static class Node {
        int  key;
        int  value;
        Node pre;
        Node next;
    }
}