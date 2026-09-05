import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

class Solution extends Exception
{
    public static void main(String[] args)
    {

    }
}

class Node implements Comparable<Node>, Comparator<Node>
{
    int val;

    @Override
    public int compareTo(Node o) {
        return this.val-o.val;
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.val;
    }
}



