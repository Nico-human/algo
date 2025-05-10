package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongzhenxun
 * @date 2025/5/8 下午8:56
 * @description 金山一面，手撕LRU
 */
public class WPS0508 {

    class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        Node() {}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private int size;
    private Node head;
    private Node tail;

    // from -> where -> group by -> having -> select -> order by -> limit

    public void WPS0508(int size) {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.size = size;

    }

    // O(1)
    public int getByKey(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node curr = map.get(key);
        moveToHead(curr);
        return curr.value;
    }

    // O(n)
    public void put(int key, int value) {
        Node curr;
        if (map.containsKey(key)) {
            curr = map.get(key);
            curr.value = value;
            moveToHead(curr);
            return;
        }

        curr = new Node(key, value);
        if (map.size() >= size) {
            Node lastNode = tail.prev;
            tail.prev = lastNode.prev;
            lastNode.prev.next = tail;
            map.remove(lastNode.key);
        }

        map.put(key, curr);
        curr.next = head.next;
        curr.prev = head;
        head.next = curr;
        curr.next.prev = curr;
    }

    public void moveToHead(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        curr.next = head.next;
        curr.prev = head;
        head.next = curr;
        curr.next.prev = curr;
    }

}