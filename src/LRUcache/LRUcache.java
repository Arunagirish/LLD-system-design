package LRUcache;

import java.util.HashMap;
import java.util.Map;

public class LRUcache
{
    class Node
    {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;
    int capacity = -1;
    Map<Integer,Node> map;

    public LRUcache(int capacity)
    {
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if(!map.isEmpty() && map.containsKey(key))
        {
            Node curr = map.get(key);
            removeNode(curr);
            addMRU(curr);
            return curr.val;
        }
        else return -1;
    }

    public void put(int key, int value)
    {
        if(!map.isEmpty() && map.containsKey(key))
        {
            Node curr = map.get(key);
            curr.val = value;
            removeNode(curr);
            addMRU(curr);
        }
        else
        {
            Node curr = new Node(key,value);
            if(capacity == map.size()) {
                Node removed = removeLRU();
                map.remove(removed.key);
            }
            map.put(key,curr);
            addMRU(curr);
        }
    }

    public Node removeLRU()
    {
        Node tobeRemoved = tail.prev;
        tobeRemoved.prev.next = tail;
        tail.prev = tobeRemoved.prev;
        return tobeRemoved;
    }

    public void removeNode(Node curr)
    {
        Node prevNode = curr.prev;
        Node nextNode = curr.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void addMRU(Node curr)
    {
        Node nextNode = head.next;
        head.next = curr;
        curr.prev = head;
        nextNode.prev = curr;
        curr.next = nextNode;
    }
}
