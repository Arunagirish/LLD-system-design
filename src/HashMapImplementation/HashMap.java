package HashMapImplementation;

public class HashMap<k,v>
{
    class Node<k,v>
    {
        int hashCode;
        k key;
        v value;
        Node next;
        Node(k key, v value)
        {
            this.key = key;
            this.value = value;
            this.hashCode = key.hashCode();
            this.next = null;
        }
    }
    private Node[] buckets;
    int capacity = 16;

    HashMap()
    {
        buckets = new Node[capacity];
    }

    void put(k key, v value)
    {
        int hashCode = key.hashCode();
        int index = hashCode%16;
        Node temp = buckets[index];

        while(temp.next != null)
        {
            if(hashCode == temp.hashCode && temp.key.equals(key))
            {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        Node<k,v> curr = new Node<>(key,value);
        buckets[index] = curr;
    }
}


class ClientCode
{
    public void print()
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
    }
}
