public class Node {
    int pos;
    Node next;
    Node prev;


    public Node(){

    }
    public Node(int pos, Node next, Node prev){
        this.pos = pos;
        this.next = next;
        this.prev = prev;
    }
}
