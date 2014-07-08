package mad;

public class Node {
    Object item;
    Node next;
    Node prev;

    Node(Object item, Node next, Node prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

}
