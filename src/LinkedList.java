public class LinkedList {

    private class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public Node first;
    public Node last;
    private int count = 0;

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        count++;
    }

    public Node reverse(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node current = head;
        Node previous =  dummy;

        while (current != null) {
            if (current.data % 2 == 0)
                previous.next =  reverseEven(current);

            previous = current;
            current = current.next;
        }

        return dummy.next;
    }

    private Node reverseEven(Node head) {
        Node current = head;
        Node previous = null;

        while (current != null && current.data % 2 == 0) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head.next = current;
        return previous;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int[] convertLinkedListToArray() {
        // [10 -> 20 -> 30]
        // [10, 20, 30]

        if(first == null) throw new IllegalStateException();

        int[] newArr = new int[count];
        var current = first;

        var index = 0;

        while(current != null) {
            newArr[index] = current.data;
            current = current.next;
            index++;
        }

        return newArr;
    }
}
