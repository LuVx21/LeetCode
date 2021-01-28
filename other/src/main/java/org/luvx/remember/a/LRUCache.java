package org.luvx.remember.a;

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
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    private void addNode(Node node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(Node node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private Node popTail() {
        Node res = tail.pre;
        this.removeNode(res);
        return res;
    }


    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity) {
                Node tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    static class Node {
        int  key;
        int  value;
        Node pre;
        Node post;
    }
}