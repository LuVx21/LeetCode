package org.luvx.remember.lru;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 * 不完善
 */
public class LRUCache1 {
    private Map<Integer, Node> map = new HashMap<>();
    private int                capacity;
    private Node               head;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            if (node != head) {
                promotionNode(node);
            }
            return head.value;
        }
    }

    public void put(int key, int value) {
        if (map.size() == 0) {
            Node node = new Node(key, value, null, null);
            node.next = node;
            node.pre = node;
            head = node;
            map.put(key, node);
            return;
        }
        Node targetValue = map.get(key);
        if (targetValue != null) {
            if (targetValue != head) {
                promotionNode(targetValue);
            }
            targetValue.value = value;
        } else {
            if (map.size() >= capacity) {
                int removeKey = head.pre.key;
                head.pre = head.pre.pre;
                map.remove(removeKey);
            }
            Node node = new Node(key, value, head, head.pre);
            map.put(key, node);
            head.pre.next = node;
            head.pre = node;
            head = node;
        }
    }

    /**
     * node 移动到最前
     *
     * @param node
     */
    private void promotionNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        head.pre.next = node;
        node.next = head;
        node.pre = head.pre;
        head.pre = node;
        head = node;
    }

    @AllArgsConstructor
    class Node {
        int  key;
        int  value;
        Node pre;
        Node next;
    }
}
